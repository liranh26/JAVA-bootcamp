package tcp.multi_threading_exe;

//rewrite our server from tcp in a way it can handle multiple clients

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

public class MultiThreadedServer {

	private final static int PORT = 8080;

	public static void main(String[] args) throws InterruptedException {

		
		// using the cache servies in order to use max thread --> max clients
		ExecutorService socketsService = Executors.newCachedThreadPool();

		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Server started on port " + PORT);

			while (true) {
				Socket clientSocket = serverSocket.accept();
				socketsService.execute(new UserRunnable(clientSocket));
			}

		} catch (IOException e) {
			System.out.println("User Server failed to start on port" + PORT);
		} finally {
			socketsService.shutdown();
			socketsService.awaitTermination(30, TimeUnit.SECONDS);
		}

	}

	static class UserRunnable implements Runnable {

		private Socket clientSocket;
		private int id;
		private User user;

		public UserRunnable(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);) {
				System.out.println(
						"User is connected" + clientSocket.getInetAddress() + ", port: " + clientSocket.getPort());

				// reading the data from the stream
				String input = bufferReader.readLine();
				System.out.println("User id sent: " + input);

				String[] words = input.split(" ");
				this.id = Integer.parseInt(words[1]);

				user = UsersDB.getuserById(id);

				// reading the expense json from the stream
				String json = bufferReader.readLine();
				Gson gson = new Gson();
				Expense expense = gson.fromJson(json, Expense.class);

				// simulate processing + fetching data..
				processData();
				
				user.addExpense(expense);

				writer.println("Processing request completed: " + user.getTotalExpenses());
				System.out.println(user.getTotalExpenses());

			} catch (IOException e) {
				System.out.println("Failed to start on port " + PORT);
				e.printStackTrace();
			}
		}
	}

	private static void processData() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
