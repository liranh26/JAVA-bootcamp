package basics;

import java.util.ArrayList;

public class Exe6_RaceCond_Example {

	private static ArrayList<Integer> intList = new ArrayList<>();
	private static final int size = 50;
	private static int sum = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < size; i++) {
			intList.add(i);
		}
		
		System.out.println("The sum of the array is : "+listSum(intList));
		
		
		Thread thread1 = new Thread(firstHalf, "First thread - First half");
		Thread thread2 = new Thread(secondHalf, "Second thread - Second half");
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		//Race condition exists here - how to handle it next subject synchronization
		System.out.println("The sum of the array by using THREADS is: "+sum);
	}

	private static int listSum(ArrayList<Integer> list) {
		int sum = 0;
		for (int num : list) {
			sum += num;
		}
		return sum;
	}
	
	public static Runnable firstHalf = () ->{
		for (int i = 0; i < intList.size()/2 ; i++) {
			sum += intList.get(i);
		}
	};
	
	public static Runnable secondHalf = () ->{
		for (int i = intList.size()/2; i < intList.size() ; i++) {
			sum += intList.get(i);
		}
	};

}
