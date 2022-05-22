package synchronization.exe4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

		final int SIZE_LIMIT = 5;

		Queue<String> queue = new LinkedList<>();

		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();

		Thread consumer = new Thread(new Consumer(queue, lock, condition));
		Thread producer = new Thread(new Producer(queue, SIZE_LIMIT,lock, condition));

		consumer.start();
		producer.start();
		
	}

}
