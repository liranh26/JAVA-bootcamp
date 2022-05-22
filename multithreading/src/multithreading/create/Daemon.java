package multithreading.create;

public class Daemon {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new SleeperRunnable(5), "sleeping beauty Thread");
		Thread thread2 = new Thread(new SleeperRunnable(3), "Prince Charming thread");

		// Deamon thread exist only if the main thread exists
		/** user threads -> to daemon**/
		thread1.setDaemon(true); 
		thread1.start();
		
		/**user thread**/
		thread2.start();

	}

	static class SleeperRunnable implements Runnable {

		private final int numSeconds;

		public SleeperRunnable(int numSeconds) {
			this.numSeconds = numSeconds;
		}

		@Override
		public void run() {
			for (int i = 0; i < numSeconds; i++) {

				try {
					System.out.println(Thread.currentThread().getName() + " is sleeping for " + (i + 1) + " sec");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}
}
