package basics;

import java.util.ArrayList;

public class Exersice3 {

	static int num = 1;
	final static int WAITING_TIME = 2000;
	final static int DELAY_START = 100;
	final static int multiplyValue = 2;

	public static void main(String[] args) throws InterruptedException {

		ThreadGroup group = new ThreadGroup("my group");

		ArrayList<Thread> threads = new ArrayList<>();

		threads.add(new Thread(group, new numThread(), "Thread 1"));
		threads.add(new Thread(group, new numThread(), "Thread 2"));
		threads.add(new Thread(group, new numThread(), "Thread 3"));

		for (Thread thread : threads) {
			thread.start();
		}

		Thread.sleep(WAITING_TIME);
		group.interrupt();

	}

	static class numThread extends Thread {
		@Override
		public void run() {
			boolean stop = false;
			while (!stop) {
				try {
					Thread.sleep(DELAY_START);
					num *= multiplyValue;
				} catch (InterruptedException e) {
					stop = true;
					System.out.println("Interrupted!");
				}

			}
			System.out.println(Thread.currentThread().getName() + ", num is:" + num);
		}
	}

}
