package basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exe4_DaemonThread {

	public static void main(String[] args) {
		// 2 list i=0 - 999 + 1000
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			list1.add(i);
			list2.add(i + 1000);
		}

		list2.set((int) (Math.random() * 1000), -1);

		/*** q4.1 - find a common value O(nlogn) ***/
		Thread thread1 = new Thread(()->{
			int i;
			//assuming that list2 is sorted - if not need to sort before
			for (i = 0; i < list1.size(); i++) {
				int result = Collections.binarySearch(list2, i);
				if(result >= 0) {
					System.out.println(Thread.currentThread().getName()+"Found a common value.");
					break;
				}
			}
			System.out.println(Thread.currentThread().getName()+" didnt find common value.");
		}, "Common Finder");
		
		
		Thread thread2 = new Thread(new checkNegative(list2), "Negative Finder");
		
		thread2.start();
		thread1.setDaemon(true);
		thread1.start();
		
		
	}

	
	
	static class checkNegative implements Runnable {

		private final int numMilSeconds = 1;
		List<Integer> list;

		public checkNegative(List<Integer> list) {
			this.list = list;
		}

		@Override
		public void run() {

			try {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) < 0) {
						Thread.sleep(numMilSeconds);
						System.out.println("Found a negative number! index:" + i);
						return;
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
