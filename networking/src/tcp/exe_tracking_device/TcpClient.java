package tcp.exe_tracking_device;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;

public class TcpClient {

	public static void main(String[] args) {

		TcpClient client = new TcpClient();

		client.runClient();
	}

	private TrackingDevice trackingDevice;
	private static final String SERVER_NAME = "localhost";
	private final static int SERVER_PORT = 8080;

	private BufferedReader bufferReader;
	private Socket clientSocket;
	private PrintWriter writer;

	public TcpClient() {
		trackingDevice = new TrackingDevice();
		trackingDevice.setLocation(new Location(12354, 55241, LocalTime.now()));
		System.out.println(trackingDevice.toString());
	}

	public void runClient() {

		int startLoc1 = 12345;
		int startLoc2 = 54321;
		while (true) {
			openSocket();

			sleep(5000);
			trackingDevice.setLocation(new Location(startLoc1++, startLoc2++, LocalTime.now()));
			sendData(trackingDevice.toString());
			readData();

			closeStreams();
		}

	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void readData() {
		InputStream inputStream;
		try {
			inputStream = clientSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream);
			bufferReader = new BufferedReader(isr);
			// reading the data from the stream
			String line = bufferReader.readLine();
			System.out.println("Server says: " + line);
		} catch (IOException e) {
			System.out.println("Failed reading data from server!");
			e.printStackTrace();
		}

	}

	private void sendData(String msg) {
		// sending data to the server by print writer
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
		if (writer != null)
			writer.close();
		if (clientSocket != null)
			try {
				clientSocket.close();
			} catch (IOException e) {
				System.out.println("Failed closing socket!");
				e.printStackTrace();
			}
	}

}
