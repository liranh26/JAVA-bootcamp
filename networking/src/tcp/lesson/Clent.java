package tcp.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import udp.client.Client;

public class Clent {
	
	private static final String SERVER_NAME="localhost";
	private final static int SERVER_PORT = 8080;
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		BufferedReader bufferReader = null;
		Socket clientSocket = null;
		PrintWriter writer = null;
		
		try {
			clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
			System.out.println("Connected to server");
			
			//sending data to the server by print writer
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println("Hello from the other side !");
			
			InputStream inputStream = clientSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream);
			bufferReader = new BufferedReader(isr);
//or in one line -> BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			
			//reading the data from the stream
			String line = bufferReader.readLine();
			System.out.println("Server says: " + line);
			
			
		} catch (UnknownHostException e) {
			System.err.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Socket failed!");
			e.printStackTrace();
		}finally {
			if(clientSocket != null)
				clientSocket.close();
			if(writer != null)
				writer.close();
		}
		
	}
	
}
