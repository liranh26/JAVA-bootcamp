package basics;

public class Exercise1 {

	static final int NUM_RUNS = 3;
	static int num = 10;

	public static void main(String[] args) {
		
		/*** thread 1 ***/
		Thread thread1 = new Thread(new numThread1(), "Thread1");
		

		
		/*** thread 2 ***/
		Runnable myRunnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < NUM_RUNS; i++) {
					num += 2;
					System.out.println("Thread 2 in action : num = " + num);
				}
			}
		};
		Thread thread2 = new Thread(myRunnable, "Thread2");
		

		
		/*** thread 3 ***/
		Thread thread3 = new Thread(() -> {
			for (int i = 0; i < NUM_RUNS; i++) {
				num /= 2;
				System.out.println("Thread 3 in action : num = " + num);
			}
		}, "Thread3");
		
		thread1.setPriority(1);
		thread3.setPriority(10);
		thread2.setPriority(5);
		
		thread3.start();
		thread2.start();
		thread1.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("The final value of num is: "+num);
	}

	
	static class numThread1 extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < NUM_RUNS; i++) {
				num *= 2;
				System.out.println("Thread 1 in action : num = " + num);
			}
		}
	}
	
}
