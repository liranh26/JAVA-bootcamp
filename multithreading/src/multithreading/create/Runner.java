package multithreading.create;

public class Runner {

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
	
		
		ThreadGroup group = new ThreadGroup("my group");
	
		group.setMaxPriority(4);

		Thread thd1 = new Thread(group, new PrinterThread(), "printer 1");
		Thread thd2 = new Thread(group, new PrinterThread(), "printer 2");
		Thread thd3 = new Thread(group, new PrinterThread(), "printer 3");
		Thread thd4 = new Thread(group, new PrinterThread(), "printer 4");
		
		System.out.println("The max priority is : "+group.getMaxPriority());
		System.out.println("thd1 prioprity is : " + thd1.getPriority());
		System.out.println("thd1 prioprity is : " + thd2.getPriority());
		System.out.println("thd1 prioprity is : " + thd3.getPriority());
		System.out.println("thd1 prioprity is : " + thd4.getPriority());
		
		System.out.println(group.getParent().getName()); // main
		// its possible to create a group inside a thread -> group inside a group
		
	}

	static class PrinterThread extends Thread {
		@Override
		public void run() {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
			System.out.println("Hello from "+ Thread.currentThread().getName());
		}
		
	}
	
	
	
}
