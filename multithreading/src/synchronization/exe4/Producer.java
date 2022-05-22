package synchronization.exe4;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {

	private static final int SLEEP_TIME = 2000;
	private final Queue<String> queue;
	private final int SIZE_LIMIT;

	private Lock lock;
	private Condition condition;

	public Producer(Queue<String> queue, int SIZE_LIMIT, Lock lock, Condition condition) {
		this.queue = queue;
		this.SIZE_LIMIT = SIZE_LIMIT;
		this.lock = lock;
		this.condition = condition;
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
		lock.lock();
		
		while (queue.size() == SIZE_LIMIT) {
			System.out.println("In producer, waiting...");
			condition.await();
		}

		Thread.sleep(SLEEP_TIME);

		queue.add("element_" + queue.size());
		System.out.println(Thread.currentThread().getName() + " is producing report with id " + queue.size());

		// let consumer know that there is already 1 element in queue to consume
		if (queue.size() == SIZE_LIMIT - 1) {
			condition.signal();
		}
		
		lock.unlock();
	}

}
