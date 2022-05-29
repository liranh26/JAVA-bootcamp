package tcp.lesson_SerializeAndJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import db.Student;
import udp.client.Client;

public class Clent {
	
	private static final String SERVER_NAME="localhost";
	private final static int SERVER_PORT = 8080;
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		BufferedReader bufferReader = null;
		Socket clientSocket = null;
		PrintWriter writer = null;
		ObjectInputStream objectInStream = null;
		
		try {
			clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
			System.out.println("Connected to server");
			
			//sending data to the server by print writer
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println("1000"); //bring the id 1000 from server
			
			
			//reading data as json
			
			//reading the data from the stream
			
			InputStream inputStream = clientSocket.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream);
			bufferReader = new BufferedReader(isr);
			String json = bufferReader.readLine();
			
			Gson gson = new Gson();
			Student student = gson.fromJson(json, Student.class);
			
			System.out.println("Server says: " + json);
			
			System.out.println(student);
			
			
		} catch (UnknownHostException e) {
			System.err.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Socket failed!");
			e.printStackTrace();
		}finally {
			if(clientSocket != null)
				clientSocket.close();
			if(objectInStream != null)
				objectInStream.close();
		}
		
	}
	
}
