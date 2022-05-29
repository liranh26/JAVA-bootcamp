package tcp.exe_JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TcpClient {

	public static void main(String[] args) {
		TcpClient client = new TcpClient(new Order(
				Arrays.asList(
						new Dish("HUMUS",18),
						new Dish("Soda", 10))));
		client.runClient();
	}
	
	
	private static final String SERVER_NAME="localhost";
	private final static int SERVER_PORT = 8080;
	private Order order;	
	
	public TcpClient(Order order) {
		this.order = order;
	}
	
	public void runClient() {
		
		try(Socket clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));){

			System.out.println("Connected to server");
			
			writer.println(order);
			
			int bill = Integer.parseInt(bufferReader.readLine());
			System.out.println("Your bill is: " + bill);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
