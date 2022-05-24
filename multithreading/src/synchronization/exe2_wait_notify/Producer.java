package synchronization.exe2_wait_notify;

import java.util.Queue;

public class Producer implements Runnable {

	private static final int SLEEP_TIME = 2000;
	private final Queue<String> queue;
	private final int SIZE_LIMIT;
	
	public Producer(Queue<String> queue, int SIZE_LIMIT) {
		this.SIZE_LIMIT = SIZE_LIMIT;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				produceData();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void produceData() throws InterruptedException {
		synchronized (queue) {
			while (queue.size() == SIZE_LIMIT) {
				System.out.println("In producer, waiting...");
				queue.wait();
			}

			Thread.sleep(SLEEP_TIME);

			queue.add("element_" + queue.size());
			System.out.println(Thread.currentThread().getName() + " is producing report with id " + queue.size());

			// let consumer know that there is already 1 element in queue to consume
			if (queue.size() == SIZE_LIMIT-1) {
				queue.notify();
			}
//			queue.notify();
		}
	}

}
