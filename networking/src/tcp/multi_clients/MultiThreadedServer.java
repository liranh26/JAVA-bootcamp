package tcp.multi_clients;

//rewrite our server from tcp in a way it can handle multiple clients

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedServer {

	private final static int PORT = 8080;

	public static void main(String[] args) throws InterruptedException {

		// using the cache servies in order to use max thread --> max clients
		ExecutorService socketsService = Executors.newCachedThreadPool();

		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Game Server started on port " + PORT);

			while (true) {
				Socket clientSocket = serverSocket.accept();
				socketsService.execute(new PlayerRunnable(clientSocket));
			}
		} catch (IOException e) {
			System.out.println("Game Server failed to start on port" + PORT);
		} finally {
			socketsService.shutdown();
			socketsService.awaitTermination(30, TimeUnit.SECONDS);
		}

	}

	static class PlayerRunnable implements Runnable {

		private Socket clientSocket;

		public PlayerRunnable(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);) {
				System.out.println(
						"Player is connected" + clientSocket.getInetAddress() + ", port: " + clientSocket.getPort());

				// reading the data from the stream
				String line = bufferReader.readLine();
				System.out.println("Player says: " + line);

				// simulate processing data..
				processData();

				writer.println("Processing request completed");

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
