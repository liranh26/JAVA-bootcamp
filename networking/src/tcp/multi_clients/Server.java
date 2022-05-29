package tcp.multi_clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private final static int PORT = 8080;

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		BufferedReader bufferReader = null;
		PrintWriter writer = null;
		
		// ServerSocket is for tcp
		try {
			
			//start server
			serverSocket = new ServerSocket(PORT);
			System.out.println("Game Server started on port " + PORT);
			
			while(true) {
				
				//accept -> is a blocking method!
				//The 3 way handshake is accurs here. if its succes it continue
				Socket clientSocket = serverSocket.accept();
				System.out.println("Player is connected" + clientSocket.getInetAddress() + ", port: " + clientSocket.getPort());
				
				
				//Socket in TCP is connected to both client and server (not like UDP)
				//it opens a stream between the two 
				
				InputStream inputStream = clientSocket.getInputStream();
				//lets create a reader ... by 3 phases
				InputStreamReader isr = new InputStreamReader(inputStream);
				bufferReader = new BufferedReader(isr);

				
				//reading the data from the stream
				String line = bufferReader.readLine();
				System.out.println("Player says: " + line);
			
				
				//simulate processing data..
				processData();
				
				//sending data to client 
				writer = new PrintWriter(clientSocket.getOutputStream(), true);
				writer.println("Processing request completed");
				
			}
			
			
			
		} catch (IOException e) {
			System.out.println("Failed to start on port " + PORT);
			e.printStackTrace();
		}finally {
			if(serverSocket != null)
				serverSocket.close();
			
			if(bufferReader != null)
				bufferReader.close();
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
