package udp.exe;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;

public class UdpServer {

	private final static int INPUT_BUFFER_SIZE = 1024;
	private final int port;
	DatagramSocket serverSocket;
	DatagramPacket receivedPacket;
	private InetAddress clientAddress;
	private int clientPort;
	private String clientMsg;
	private HashMap<String, Weather> cities;
	private String CITY_NOT_EXIST ="0" , CITY_EXIST = "1";

	public UdpServer(int port) {
		this.port = port;
		openServerSocket();
		System.out.println("Server is listeing on port: " + port);
		initializeCityMap();
	}

	public void runServer() {
		while (true) {
			receivedPacket = receiveData();
			String clientCity = getDataFromClient();
			
			if (!checkCityExists(clientCity)) {
				System.out.println("The city doesnt exist");
				sendBackData(CITY_NOT_EXIST);
				continue;
			} else {
				sendBackData(CITY_EXIST);
			}
			
			receivedPacket = receiveData();
			String request = getDataFromClient();

			// prepare packet to send back to client
			String response = null;

			switch (request) {
			case "temperature":
				System.out.println(cities.get(clientCity).temperature);
				response = getTempByCity(clientCity);
				break;
			case "humidty":
				response = getHumdityByCity(clientCity);
				break;
			case "both":
				response = getHumdityByCity(clientCity) +" "+ getTempByCity(clientCity);
			}

			sendBackData(response);
			
		}
	}

	
	
	private String getDataFromClient() {
		clientAddress = receivedPacket.getAddress(); // hostname + IP
		clientPort = receivedPacket.getPort();
		clientMsg = new String(receivedPacket.getData()).trim();
		System.out.println("client " + clientAddress + ", sent: " + clientMsg);
		return clientMsg;
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

	
	private void sendBackData(String msg) {
		
		//prepare packet to send back to client
		byte[] myBytes = msg.getBytes();
		//create datagram packet to send
		DatagramPacket packetToSend = new DatagramPacket(myBytes, myBytes.length, clientAddress, clientPort);
		try {
			serverSocket.send(packetToSend);
		} catch (IOException e) {
			System.out.println("Server failed to connect with client");
			e.printStackTrace();
		}
		System.out.println("Server sent response " + msg);
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
	
	
	private void initializeCityMap() {
		cities = new HashMap<>();
		cities.put("Tel-Aviv", new Weather("70%", "27.6C"));
		cities.put("Ashkelon", new Weather("85%", "29C"));
		cities.put("Ashdod", new Weather("80%", "28.5C"));
		cities.put("Yavne", new Weather("50%", "27C"));
		cities.put("Rishon", new Weather("75%", "27.5C"));
	}
	
	
	private String getHumdityByCity(String city) {
		if (!checkCityExists(city))
			return "The city doesnt exist";
		return cities.get(city).humidty;
	}

	private String getTempByCity(String city) {
		if (!checkCityExists(city))
			return "The city doesnt exist";
		return cities.get(city).temperature;
	}

	private boolean checkCityExists(String city) {
		return cities.containsKey(city);
	}

}
