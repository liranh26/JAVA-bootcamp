package synchronization.exe2;

import java.util.Queue;

public class Consumer implements Runnable {

	private static final int SLEEP_TIME = 1000;
	private final Queue<String> queue;
	private final int SIZE_LIMIT;
	
	public Consumer(Queue<String> queue, int SIZE_LIMIT) {
		this.SIZE_LIMIT = SIZE_LIMIT;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				consumeData();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consumeData() throws InterruptedException {
		synchronized (queue) {
			// wait id there's nothing to consume
			while (queue.isEmpty()) {
				System.out.println("Consumer is waiting...");
				queue.wait();
			}

			Thread.sleep(SLEEP_TIME);


			System.out.println("Consumed data: " + queue.size());
			queue.remove();

			// let producer know that the consuming started
			if (queue.size() == 1) {
				queue.notify();
			}

		}
	}

}
