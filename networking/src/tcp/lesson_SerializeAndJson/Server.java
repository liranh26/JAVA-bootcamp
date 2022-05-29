package tcp.lesson_SerializeAndJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import db.Student;
import db.StudentDB;

public class Server {

	private final static int PORT = 8080;

	/*
	 * working with java objects
	 * the pros: no need external libraries
	 * the cons: if we need to send the object to a server he might not know to read it
	 * 			 so mybe we will need to cast it to json.
	 * note: most of dbs know to read json!  
	 */
	
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		BufferedReader bufferReader = null;
		PrintWriter writer = null;
		ObjectOutputStream objectOutStream = null;
		
		// ServerSocket is for tcp
		try {
			
			//start server
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started on port " + PORT);
			
			while(true) {
				
				//accept -> is a blocking method!
				//The 3 way handshake is accurs here. if its succes it continue
				Socket clientSocket = serverSocket.accept();
				System.out.println("client is connected" + clientSocket.getInetAddress() + ", port: " + clientSocket.getPort());
				
				
				//Socket in TCP is connected to both client and server (not like UDP)
				//it opens a stream between the two 
				
				InputStream inputStream = clientSocket.getInputStream();
				//lets create a reader ... by 3 phases
				InputStreamReader isr = new InputStreamReader(inputStream);
				bufferReader = new BufferedReader(isr);
// or in one line -> BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				
				//reading the data from the stream
				String receivedId = bufferReader.readLine();
				System.out.println("Client says: " + receivedId);
				long id = Long.parseLong(receivedId);
			
				//get Student from db (we dont cjeck if he doesnt exist)
				Student student = StudentDB.getStudentById(id);
				
				
				// ---- sending data as json ----
				//preparing the string to send by the writer 
				Gson gson = new Gson();
				String studentJson = gson.toJson(student, Student.class);
				
				//sending data to client 
				writer = new PrintWriter(clientSocket.getOutputStream(), true);
				writer.println(studentJson);
				
				System.out.println("Student sent to the client: \n"+student); //print for debuging
			}
			
			
			
		} catch (IOException e) {
			System.out.println("Failed to start on port " + PORT);
			e.printStackTrace();
		}finally {
			if(serverSocket != null)
				serverSocket.close();
			
			if(objectOutStream != null)
				objectOutStream.close();
		}
	}

}
