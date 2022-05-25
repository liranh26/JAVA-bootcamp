package udp.exe;

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
	private final String CITY_NOT_EXIST ="0";
	private boolean finished = false;
	
	public UdpClient(int port) {
		this.port = port;
		openSocket();
		runClient();
	}
	
	public void runClient() {
		String dataToSend = null;
		
		while(!finished) {
			System.out.println("Enter a city: ");
			dataToSend = userInput();
			DatagramPacket packetToSend = createDataGram(dataToSend);
			sendPacket(packetToSend);
			
			String response = receiveResponseFromServer(); 
			if(response.equals(CITY_NOT_EXIST))
				continue;
			printMenu();
			System.out.println("Enter a your choise: ");
			String choise = userInput();
			
			switch(choise) {
			case "1":
				dataToSend = "temperature";
				break;
			case "2":
				dataToSend = "humidty";
				break;
			case "3":
				dataToSend = "both";	
			}
			
			packetToSend = createDataGram(dataToSend);
			sendPacket(packetToSend);
			
			System.out.println(receiveResponseFromServer()); 
			finished = true;
			
		}
		
		sc.close();

	}
	
	private String userInput() {
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
	
	private String receiveResponseFromServer() {
		byte[] buffer = new byte[INPUT_BUFFER_SIZE];
		DatagramPacket receivedPacket = new DatagramPacket(buffer, INPUT_BUFFER_SIZE);
		//receive data from server
		try {
			clientSocket.receive(receivedPacket); // -> blocking method! waiting for response
		} catch (IOException e) {
			System.out.println("Client failed to send datagram!");
			e.printStackTrace();
		}
		String serverMsg = new String(receivedPacket.getData()).trim();
		return serverMsg;
	}
	
	private void printMenu() {
		System.out.println("What would you like to know?\n" + "1. Temperature\n2. Humidty \n3. Both");
	}
}
