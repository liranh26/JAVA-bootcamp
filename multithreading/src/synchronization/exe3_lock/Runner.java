package synchronization.exe3_lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	static int sum = 0;
	static final int NUM_THREADS = 2;
	static final int SIZE = 50;
	static Lock mutex = new ReentrantLock();

	static ArrayList<Integer> intList = new ArrayList<>(SIZE);

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < SIZE; i++) {
			intList.add((int) (Math.random() * 50));
		}
		printSum(serializeSum(intList));

		Thread thd1 = new MyThread(0, SIZE / NUM_THREADS);
		Thread thd2 = new MyThread(SIZE / NUM_THREADS, SIZE);

		thd1.start();
		thd2.start();

		thd1.join();
		thd2.join();

		System.out.println("The parallel sum is : " + sum);

	}

	static int serializeSum(List<Integer> nums) {
		return nums.stream().reduce(0, (a, b) -> a + b);
	}

	static void printSum(int sum) {
		System.out.println("The serialize sum is : " + sum);
	}

	static class MyThread extends Thread {

		private int start;
		private int end;

		public MyThread(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {
			for (int i = start; i < end; i++) {
				mutex.lock();
				sum += intList.get(i);
				mutex.unlock();
			}
		}

	}

}
