package udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * An implements of UDP server
 * 1. udp server doesnt need a hand shack - its sends the datagram.
 * 2. for udp server we need server socket -> datagram socket
 */

public class Server {

	// buffer array
	private final static int INPUT_BUFFER_SIZE = 1024;
	private final static int OUTPUT_BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		// port the address of the app o
		int port = 4444;
		try {
			DatagramSocket serverSocket = new DatagramSocket(port);
			System.out.println("Server started on port " + port);

			// lets start listing to our port
			System.out.println("Server is listeing on port: " + port);
			while (true) {
				
				// handle data - all communication drives through datagram packet
				// the buffer is the place we receive the input data
				// we will translate the bytes the strings eventually
				byte[] inputbuffer = new byte[INPUT_BUFFER_SIZE];
				DatagramPacket receivedPacket = new DatagramPacket(inputbuffer, INPUT_BUFFER_SIZE);
				
				
				// method of the receiving packets - this is a blocking method!
				// we will wait here until a client will send data...
				serverSocket.receive(receivedPacket);

				// getting the client address info via Inet
				// why we need this info ? -> for echo server, send back to the client
				InetAddress clientAddress = receivedPacket.getAddress(); // hostname + IP
				int clientPort = receivedPacket.getPort();

				// get client message -> getData() returns byte[] array.
				// we save into the input buffer.. to avoid unnecessary data (zeros) we do trim.
				String clientMsg = new String(receivedPacket.getData()).trim();

				// print the client msg for debugging
				System.out.println("client " + clientAddress + ", sent: " + clientMsg);
				
				//prepare packet to send back to client
				byte[] myBytes = clientMsg.getBytes();
				//create datagram packet to send
				DatagramPacket packetToSend = new DatagramPacket(myBytes, myBytes.length, clientAddress, clientPort);
				
				//send packet back to client
				serverSocket.send(packetToSend);
				System.out.println("Server echo response sent");
			}

		} catch (SocketException e) {
			System.err.println("Server Connection failed!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Server failed to connect with client");
			e.printStackTrace();
		}
	}
}
