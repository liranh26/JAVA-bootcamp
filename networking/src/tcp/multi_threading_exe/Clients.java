package tcp.multi_threading_exe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

public class Clients {

	private static final String SERVER_NAME = "localhost";
	private final static int SERVER_PORT = 8080, NUM_USERS = UsersDB.getNumUser();

	public static void main(String[] args) throws IOException, InterruptedException {

		ExecutorService playersService = Executors.newFixedThreadPool(NUM_USERS);

		// adding a latch that will help to execute all threads simultaneously
		// it will have the number of threads and await until it will be zero (the last
		// will open all threads)
		CountDownLatch latch = new CountDownLatch(NUM_USERS);

		// each thread will simulate a client
		for (int i = 0; i < NUM_USERS; i++) {
			playersService.execute(new UserRunnable(UsersDB.getuserById(i), latch,
					new Expense(ExpenseCategory.FOOD, LocalDateTime.now(), 125d)));
		}

		playersService.shutdown();
		playersService.awaitTermination(30, TimeUnit.SECONDS);

	}

	private static class UserRunnable implements Runnable {

		private User user;
		private CountDownLatch latch;
		private Expense expense;

		public UserRunnable(User user, CountDownLatch latch, Expense expense) {
			this.user = user;
			this.latch = latch;
			this.expense = expense;
		}

		@Override
		public void run() {

			try (Socket clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
					BufferedReader bufferReader = new BufferedReader(
							new InputStreamReader(clientSocket.getInputStream()));
					PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);) {

				latch.countDown();
				latch.await(); //once the countdown is 0 its release the threads

				System.out.println("Connected to server");

				// sending User id to the server by print writer
				writer.println("User %d".formatted(user.getId()));

				Gson gson = new Gson();
				String expenseJson = gson.toJson(expense, Expense.class);
				writer.println(expenseJson);

				// start timer
				long start = System.currentTimeMillis();

				// reading the data from the stream
				String line = bufferReader.readLine();

				// end timer
				long end = System.currentTimeMillis();

				System.out.println("Server says: " + line + ", After : " + (end - start) + " [ms]");

			} catch (UnknownHostException e) {
				System.err.println("Server is not found");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Socket failed!");
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
