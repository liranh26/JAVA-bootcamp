package tcp.multi_clients;

//500 players 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiPlayersSimulation {
	
	
	private static final String SERVER_NAME="localhost";
	private final static int SERVER_PORT = 8080, NUM_PLAYERS=10;
	
	public static void main(String[] args) throws IOException, InterruptedException {
	
		
		ExecutorService playersService = Executors.newFixedThreadPool(NUM_PLAYERS);

		//adding a lock that will help to execute all threads simulatimsely
		//it will have the number of threads and await until it will be zero (the last will open all threads)
		CountDownLatch latch = new CountDownLatch(NUM_PLAYERS); 
		
		//each thread will simulate a client
		for (int i = 0; i < NUM_PLAYERS; i++) {
			playersService.execute(new PlayerRunnable(i, latch));
		}
		
		playersService.shutdown();
		playersService.awaitTermination(30, TimeUnit.SECONDS);
		
	}
	
	
	private static class PlayerRunnable implements Runnable{

		private int num;
		private CountDownLatch latch;
		
		public PlayerRunnable(int num, CountDownLatch latch) {
			this.num = num;
			this.latch = latch;
		}

		//run creats a client (player)
		@Override
		public void run() {

			BufferedReader bufferReader = null;
			Socket clientSocket = null;
			PrintWriter writer = null;
			
			try {
				//for every socket opened we will count down -> the first 9 will lock and the 10 will release all
				latch.countDown(); //this is not blocking
				latch.await(); //once the countdown is 0 its release the await
				
				clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
				System.out.println("Connected to server");
				
				//sending data to the server by print writer
				writer = new PrintWriter(clientSocket.getOutputStream(), true);
				writer.println("Player #%d sent request".formatted(num));
				
				InputStream inputStream = clientSocket.getInputStream();
				InputStreamReader isr = new InputStreamReader(inputStream);
				bufferReader = new BufferedReader(isr);
				
				//start timer
				long start = System.currentTimeMillis();
				
				//reading the data from the stream
				String line = bufferReader.readLine();
				
				//end timer
				long end = System.currentTimeMillis();
				
				System.out.println("Server says: " + line + ", After : " + (end-start) + " [ms]");
				
				
			} catch (UnknownHostException e) {
				System.err.println("Server is not found");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Socket failed!");
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				if(clientSocket != null)
					try {
						clientSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if(writer != null)
					writer.close();
				if(bufferReader != null)
					try {
						bufferReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}	
	}
	
}
