package tcp.exe_JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class TcpServer {

	public static void main(String[] args) {
		TcpServer server = new TcpServer(8080);
		server.runServer();
	}
	
	
	private final int PORT;
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public TcpServer(int port) {
		this.PORT = port;
	}

	public void runServer() {

		while (true) {
			
			openSocket();
			
			try (	
					BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);) {
				
				System.out
						.println("Client is connected" + clientSocket.getInetAddress() + ", port: " + clientSocket.getPort());

				// reading the data from the stream
				String json = bufferReader.readLine();
				System.out.println("Client says: " + json);
				
				//convert json to object
				Gson gson = new Gson();
				Order order = gson.fromJson(json, Order.class);
				
				//send to client bill
				writer.println(order.getBill());
				
			} catch (IOException e) {
				System.err.println("Failed to connect to client");
				e.printStackTrace();
			}

		}

	}

	private void openSocket() {
		try {
			serverSocket = new ServerSocket(PORT);
			clientSocket = serverSocket.accept();
			System.out.println("Server started on port " + PORT);
		} catch (IOException e) {
			System.out.println("Failed to start on port " + PORT);
			e.printStackTrace();
		}
	}

}
