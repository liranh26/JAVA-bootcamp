package udp.server_client_template;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	public static void main(String[] args) {
	
		Lock lock = new ReentrantLock();
		
		lock.lock();
		Thread serverThread = new Thread(()->{
			UdpServer server = new UdpServer(4444);
			server.runServer();
		});
		lock.unlock();
		lock.lock();
		Thread clientThread = new Thread(()->{
			UdpClient client = new UdpClient(4445);
			client.runClient();
		});
		lock.unlock();
		
		
		serverThread.start();
		clientThread.start();
		
	}

}
