package udp.server_client_template;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer {

	private final static int INPUT_BUFFER_SIZE = 1024;
	private final int port;
	DatagramSocket serverSocket;
	DatagramPacket receivedPacket;
	private InetAddress clientAddress;
	private int clientPort;
	private String clientMsg;

	
	public UdpServer(int port) {
		this.port = port;
		openServerSocket();
		System.out.println("Server is listeing on port: " + port);
	}

	public void runServer() {
		while (true) {
			receivedPacket = receiveData();
			getClientInfo();
			sendBackEcho();
		}
	}
	
	private void getClientInfo() {
		clientAddress = receivedPacket.getAddress(); // hostname + IP
		clientPort = receivedPacket.getPort();
		clientMsg = new String(receivedPacket.getData()).trim();
		System.out.println("client " + clientAddress + ", sent: " + clientMsg);
	}
	
	private DatagramPacket receiveData() {
		byte[] inputbuffer = new byte[INPUT_BUFFER_SIZE];
		DatagramPacket receivedPacket = new DatagramPacket(inputbuffer, INPUT_BUFFER_SIZE);

		try {
			serverSocket.receive(receivedPacket);
		} catch (IOException e) {
			System.out.println("Server failed to connect with client");
			e.printStackTrace();
		}
		
		return receivedPacket;
	}

	
	private void openServerSocket() {
		try {
			serverSocket = new DatagramSocket(port);
			System.out.println("Server started on port " + port);
		} catch (SocketException e) {
			System.err.println("Server Connection failed!");
			e.printStackTrace();
		}
	}

	
	private void sendBackEcho() {
		//prepare packet to send back to client
		byte[] myBytes = clientMsg.getBytes();
		//create datagram packet to send
		DatagramPacket packetToSend = new DatagramPacket(myBytes, myBytes.length, clientAddress, clientPort);
		try {
			serverSocket.send(packetToSend);
		} catch (IOException e) {
			System.out.println("Server failed to connect with client");
			e.printStackTrace();
		}
		System.out.println("Server echo response sent");
	}

}
