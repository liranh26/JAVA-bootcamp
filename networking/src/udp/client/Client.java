package udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private final static int INPUT_BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String dataToSend = null;
		
		// Server to send requests
		String serverName = "localhost";// possible also throught ip..
		int serverPort = 4444;
		int port = 4445; // -> client port
		
		
		DatagramSocket clientSocket = null;
		try {
			// creating client socket
			clientSocket = new DatagramSocket(port);
			System.out.println("Client started on port: " + port);
			
			do {
			// creating data
			System.out.println("Enter a message to send");
			dataToSend = sc.nextLine();

			// creating datagram
			byte[] msgBytes = dataToSend.getBytes();
			DatagramPacket packetToSend = new DatagramPacket(msgBytes, msgBytes.length,
					InetAddress.getByName(serverName), serverPort);
			
			// send packet
			clientSocket.send(packetToSend);

			
			//prepare packet for receiving data from server - need datagram, buffer
			byte[] buffer = new byte[INPUT_BUFFER_SIZE];
			DatagramPacket receivedPacket = new DatagramPacket(buffer, INPUT_BUFFER_SIZE);
			
			//receive data from server
			clientSocket.receive(receivedPacket); // -> blocking method! waiting for response
			String serverMsg = new String(receivedPacket.getData(), receivedPacket.getOffset(), receivedPacket.getLength()).trim();
			
			System.out.println("Server response: " + serverMsg);
			
			}while(!dataToSend.toLowerCase().equals("quit"));
		
		} catch (SocketException e) {
			System.err.println("Client socket creation failed!");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			System.err.println("Could not found Server address!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Client failed to send datagram!");
			e.printStackTrace();
		} finally {
			System.out.println("client disconnected");
			if (clientSocket != null)
				clientSocket.close();
		}
		
		sc.close();

	}

}
