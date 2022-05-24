package basics;

import java.util.ArrayList;
import java.util.List;

public class Exe5_ExceptionHandlers {

	private static final int numIntegers = 1000;
	private static final int numOfNulls = 3;
	
	static List<Integer> intList = new ArrayList<>();
	static List<String> list2 = new ArrayList<>();
	
	public static void main(String[] args) {

		for (int i = 0; i < numIntegers; i++) {
			intList.add((int)(Math.random()*numIntegers));
		}
		
		for (int i = 0; i < numOfNulls; i++) {
			intList.set((int)(Math.random()*numIntegers), null);			
		}
		
		
		List<Integer> list1 = new ArrayList<>();
		List<Double> list3 = new ArrayList<>();
		
		Thread thread1 = new Thread(()->{
			for (Integer num : intList) {
				try {
					list1.add(num*2);
				}catch(NullPointerException e) {
					System.out.println("Null value in cell! : " + e);
					list1.add(-1);
					continue;
				}
			}
			
		}, "Thread - doubles int");
		
		
		
		/*** thread2 - using Uncaught Exception to catch exception ***/
		Thread thread2 = new Thread(doubleRunnable, "Thread - Doubles values of list");
		
		thread2.setUncaughtExceptionHandler((thread, exception) -> {
			System.out.println("Something went wrong! "+ exception);
		});
		//note - if the there is no setUncaughtExceptionHandler, the next handler to take place in is ThreadGroup object acts as its handler.
		

		
		/*** Default Uncaught ExceptionHandler ***/
		Thread.setDefaultUncaughtExceptionHandler(((thread, exception) -> {
			System.out.println("Defualt Exception Handler - Something went wrong! "+ exception);
		}));
		
		Thread thread3 = new Thread(()->{
			for (Integer num : intList) {
					list3.add((double)(num/5));
			}
			
		}, "Thread - doubles int");
		
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

	public static Runnable doubleRunnable = () ->{
		for (int value : intList) {
				list2.add("" + (value + 1));
		}
	};
	
}
