package javabootcamp.basic.loops;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		
		
//		// ******* lesson q1 - check if a number is prime *******
//
//		System.out.println("Enter a number: ");
//		int userInput = scanner.nextInt();
//		
//		String isPrime = "prime";
//		
//		for(int i=2 ; i<userInput ; i++) {  //sqrt will improve effiency! (didnt learned yet)
//			if(userInput % i == 0) {
//				isPrime = "NOT prime";
//				break;
//			}
//		}
//		
//		System.out.println("The number "+userInput+ " is "+ isPrime);
		

		
//		// ******* lesson q2 - print input numbers by user *******
//		
//		int userInput = 0, doz=1 , result = 0;
//		
//		System.out.println("Enter a number: ");
//		userInput = scanner.nextInt();
//		
//		while(userInput >= 0) {
//			
//			if(userInput>0) {
//				result += userInput * doz;
//				doz *= 10;
//			}
//			
//			System.out.println("Enter a number: ");
//			userInput = scanner.nextInt();
//		}
//		
//		System.out.println("The number created: " + result);
		

		
		
//		// ******* lesson q3 - print the input numbers by user ******* 
//		int num=0;
//		int i=1;
//		int res=0;
//		
//		do {
//			System.out.println("Enter a number: ");
//			
//			res*=10;
//			res+=num;
//			num = scanner.nextInt();
//					
//		}while (num >= 0);
//		
//		System.out.println("The number created: " + res);
		

		
//		// ******* lesson q4 - output the inputs product ********
//		int num = 1, product = 0, multi = 1;
//		System.out.println("Enter a number: ");
//		
//		do {
//			
//			num = scanner.nextInt();
//			if(num>0) {
//				product = multi * num;
//				multi = product;
//			}
//
//		} while (num > 0);
//		
//		System.out.println("The number created: " + product);

		
		
		
		scanner.close();

	}

}
