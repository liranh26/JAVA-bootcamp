package multithreading.create;

public class StatesPriorty {

	public static void main(String[] args) {
		
		/*** gut current thread ***/
		Thread thread = Thread.currentThread(); // the JVM sends the current thread
		System.out.println(thread);
		System.out.println(thread.getState()+", "+ thread.getName());
		
		/*** create thread using extension ***/
//		PrinterThread thread1 = new PrinterThread();
		Thread thread1 = new Thread(new PrinterThread(), "printer thread");
		thread1.start(); //may take some time to print then it move to next and print the main
//		thread1.run();
		
		try {
			thread1.join(); // will wait here for all threads to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		/*** creating thread using the runnable interface ***/
		Runnable myRunnable = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Java is awesome!!");
				}
				
			}
		};
		Thread thread2 = new Thread( myRunnable);
		thread2.start();
		
		System.out.println(thread.getName());
		
		Thread thread3 = new Thread(()->{
			for (int i = 0; i < 3; i++) {
				System.out.println("Hello "+Thread.currentThread().getName());
			}
		},"thread3");
		thread3.start();
	}

	static class PrinterThread extends Thread {
		@Override
		public void run() {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println("Hello from "+ Thread.currentThread().getName());
		}
		
		
	}
	
}
