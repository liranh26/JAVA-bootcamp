package tcp.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private final static int PORT = 8080;

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		BufferedReader bufferReader = null;
		PrintWriter writer = null;
		
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
				String line = bufferReader.readLine();
				System.out.println("Client says: " + line);
			
				//sending data to client 
				writer = new PrintWriter(clientSocket.getOutputStream(), true);
				writer.println("I must have called a thousand times");
				
			}
			
			
			
		} catch (IOException e) {
			System.out.println("Failed to start on port " + PORT);
			e.printStackTrace();
		}finally {
			if(serverSocket != null)
				serverSocket.close();
			
			if(bufferReader != null)
				bufferReader.close();
		}
	}

}
