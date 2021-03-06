package tcp.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient {
	
	public static void main(String[] args) {

			TcpClient client = new TcpClient();
			

	}
	
	private static final String SERVER_NAME="localhost";
	private final static int SERVER_PORT = 8080;
	

	private BufferedReader bufferReader;
	private Socket clientSocket;
	private PrintWriter writer;
	
	public TcpClient() {
		openSocket();
		sendData("Hello from the other side !");
		readData();
		
		closeStreams();
	}
	
	private void readData() {
		InputStream inputStream;
		try {
			bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			//reading the data from the stream
			String line = bufferReader.readLine();
			System.out.println("Server says: " + line);
		} catch (IOException e) {
			System.out.println("Failed reading data from server!");
			e.printStackTrace();
		}
		
	}
	
	private void sendData(String msg) {
		//sending data to the server by print writer
		try {
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println(msg);
		} catch (IOException e) {
			System.out.println("Sending data to server failed!");
			e.printStackTrace();
		}
	}
	
	private void openSocket() {
		try {
			clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
			System.out.println("Connected to server");
		} catch (IOException e) {
			System.out.println("Connection to server failed!");
			e.printStackTrace();
		}
	}
	
	private void closeStreams() {
		if(writer != null)
			writer.close();
		if(clientSocket != null)
			try {
				clientSocket.close();
			} catch (IOException e) {
				System.out.println("Failed closing socket!");
				e.printStackTrace();
			}
	}
	
}
