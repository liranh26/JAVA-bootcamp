package synchronization.exe2_wait_notify;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		
		final int SIZE_LIMIT = 5;
		
		Queue<String> queue = new LinkedList<>() ;

		Thread cunsomerThd = new Thread(new Consumer(queue, SIZE_LIMIT));
		Thread producerThd = new Thread(new Producer(queue, SIZE_LIMIT));
		
		producerThd.start();
		cunsomerThd.start();
		
		producerThd.join();
		cunsomerThd.join();
		
	}

}
