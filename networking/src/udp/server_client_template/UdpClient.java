package udp.server_client_template;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpClient {
	private final static int INPUT_BUFFER_SIZE = 1024;
	private String serverName = "localhost";
	private int serverPort = 4444, port;
	private DatagramSocket clientSocket;
	Scanner sc = new Scanner(System.in);
	
	public UdpClient(int port) {
		this.port = port;
		openSocket();
		runClient();
	}
	
	public void runClient() {
		String dataToSend = null;
		do {
			dataToSend = userInput();
			DatagramPacket packetToSend = createDataGram(dataToSend);
			sendPacket(packetToSend);
			
			System.out.println(receiveEchoFromServer());
			
		}while(!dataToSend.toLowerCase().equals("quit"));
	}
	
	private String userInput() {
		System.out.println("Enter a message to send");
		return sc.nextLine();
	}
	
	private void openSocket() {
		try {
			clientSocket = new DatagramSocket(port);
			System.out.println("Client started on port: " + port);
		} catch (SocketException e) {
			System.err.println("Client socket creation failed!");
			e.printStackTrace();
		}
	}
	
	private DatagramPacket createDataGram(String dataToSend) {
		byte[] msgBytes = dataToSend.getBytes();
		DatagramPacket packetToSend=null;
		try {
			packetToSend = new DatagramPacket(msgBytes, msgBytes.length,
					InetAddress.getByName(serverName), serverPort);
		} catch (UnknownHostException e) {
			System.err.println("Could not found Server address!");
			e.printStackTrace();
		}
		return packetToSend;
	}
	
	private void sendPacket(DatagramPacket packetToSend) {
		try {
			clientSocket.send(packetToSend);
		} catch (IOException e) {
			System.out.println("Client failed to send datagram!");
			e.printStackTrace();
		}
	}
	
	private String receiveEchoFromServer() {
		byte[] buffer = new byte[INPUT_BUFFER_SIZE];
		DatagramPacket receivedPacket = new DatagramPacket(buffer, INPUT_BUFFER_SIZE);
		//receive data from server
		try {
			clientSocket.receive(receivedPacket); // -> blocking method! waiting for response
		} catch (IOException e) {
			System.out.println("Client failed to send datagram!");
			e.printStackTrace();
		}
		String serverMsg = new String(receivedPacket.getData(), receivedPacket.getOffset(), receivedPacket.getLength()).trim();
		return serverMsg;
	}
}
