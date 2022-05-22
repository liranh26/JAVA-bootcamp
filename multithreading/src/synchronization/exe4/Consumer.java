package synchronization.exe4;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {

	private static final int SLEEP_TIME = 1000;
	private final Queue<String> queue;

	private Lock lock;
	private Condition condition;

	public Consumer(Queue<String> queue, Lock lock, Condition condition) {
		this.queue = queue;
		this.lock = lock;
		this.condition = condition;
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
		lock.lock();

		while (queue.isEmpty()) {
			System.out.println("Consumer is waiting...");
			condition.await();
		}

		Thread.sleep(SLEEP_TIME);

		System.out.println("Consumed data: " + queue.size());
		queue.remove();

		if (queue.size() == 1) {
			condition.signal();
		}

		lock.unlock();

	}

}
