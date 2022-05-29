package tcp.exe_tracking_device;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class TcpServer {

	public static void main(String[] args) {

		TcpServer server = new TcpServer(8080);
		server.runServer();
	}

	private final int PORT;
	private ServerSocket serverSocket;
	private BufferedReader bufferReader;
	private PrintWriter writer;
	private Socket clientSocket;
	private HashMap<String, ArrayList<String>> db;

	public TcpServer(int port) {
		this.PORT = port;
		db = new HashMap<>();
	}

	public void runServer() {

		openSocket();

		while (true) {
			connectSocket();
			openBufferReader();
			String trackerInfo = readFromBuffer();
			String id = getIdFromString(trackerInfo);
			System.out.println(id);

			insertData(id, trackerInfo);
			sendData("Data recieved : " + trackerInfo);

		}
	}

	private void insertData(String id, String trackerInfo) {
		if (db.containsKey(id))
			db.get(id).add(trackerInfo);
		else {
			ArrayList<String> data = new ArrayList<>();
			data.add(trackerInfo);
			db.put(id, data);
		}
	}

	private void openSocket() {
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started on port " + PORT);
		} catch (IOException e) {
			System.out.println("Failed to start on port " + PORT);
			e.printStackTrace();
		}
	}

	private void connectSocket() {
		try {
			clientSocket = serverSocket.accept();
			System.out.println(
					"client is connected" + clientSocket.getInetAddress() + ", port: " + clientSocket.getPort());
		} catch (IOException e) {
			System.out.println("Failed to connect to client");
			e.printStackTrace();
		}
	}

	private void openBufferReader() {
		InputStream inputStream;
		try {
			inputStream = clientSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream);
			bufferReader = new BufferedReader(isr);

		} catch (IOException e) {
			System.out.println("Failed to open a stream!");
			e.printStackTrace();
		}
	}

	private String readFromBuffer() {
		// reading the data from the stream
		String line = "";
		try {
			line = bufferReader.readLine();
			System.out.println("Client says: " + line);
		} catch (IOException e) {
			System.out.println("Failed to read the stream!");
			e.printStackTrace();
		}
		return line;
	}

	private void sendData(String data) {
		// sending data to client
		try {
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println(data);
		} catch (IOException e) {
			System.out.println("Failed to send data stream!");
			e.printStackTrace();
		}
	}

	private String getIdFromString(String str) {
		if (str == null)
			return "";
		String[] words = str.split(" ");
		return words[words.length - 1].replace("]", "");
	}

}
