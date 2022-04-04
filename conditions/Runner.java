package javabootcamp.basic.conditions;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		// ******** question 1 - calculate area & circumference for a given radius ********
//		
//		System.out.println("please enter a radius:");
//		float radius = scanner.nextFloat();
//		
//		float pai = 3.14f;
//		float circ = 2 * pai * radius;
//		float area = radius * radius * pai;
//		System.out.printf("For given redius: %.2f the circumference is: %.2f and the area is: %.2f",radius ,circ , area);
//		

		// ******** question 2 - calculating a toast price ********
		
//		int basicPrice = 12;
//		System.out.println("Regualar aditions: olives, mushrumos, corn");
//		System.out.println("please enter the amount of Regualar aditions to your toast:");
//		int regualarAditions = scanner.nextInt();
//		
//		System.out.println("Regualar aditions: bulgarian cheese, extra cheese");
//		System.out.println("please enter the amount of Special aditions to your toast:");
//		int specialAditions = scanner.nextInt();
//		
//		int totalPrice = basicPrice + regualarAditions * 2 + specialAditions * 3;
//		
//		System.out.println("Your bill for the toast is:" + totalPrice);

		
		// ******** question 3 - calculating bill for a sofa including delivery ********
		
//		System.out.println("Please enter the amount of the sofa price");
//		int sofaPrice = scanner.nextInt();
//		
//		System.out.println("Please enter the amount of the sofa weight in kg:");
//		int weight = scanner.nextInt();
//		
//		System.out.println("Please enter the distance you live in km:");
//		int distance = scanner.nextInt();
//		
//		System.out.println("Please enter your apartment floor:");
//		int floor = scanner.nextInt();
//		
//		double totalPrice = sofaPrice + distance*5 + floor*weight + sofaPrice*0.1;
//		System.out.println("The total amount of the sofa is: "+ totalPrice);
		
		
		// **lesson q1.1 check is a number dividable by 1 2 3 4**
//		System.out.println("Please enter a number:");
//		int userInput = scanner.nextInt();
//		
		//** naive solution **
//		if(userInput % 3 == 0 && userInput % 4 == 0) {
//			System.out.println(userInput + " is dividable by 1, 2, 3, 4.");
//		}
		
//		//** more elegant way ** 
//		final int DIVISOR = 12;
////		String result = "";		
////		if(userInput % DIVISOR != 0) {
////			result = "NOT ";
////		}
//		//** using a ternary operator // 
//		String result = (userInput % DIVISOR == 0) ? "" : "NOT ";
//		
//		System.out.println(userInput + " is "+ result + "dividable by 1, 2, 3, 4.");			
//		System.out.println("Goodbye");
	
//		//** lesson q2 - range of one input between two inputs
//	
//		System.out.println("Please enter a number:");
//		int numCheck = scanner.nextInt();
//		
//		System.out.println("Please enter a range number:");
//		int start = scanner.nextInt();
//		
//		System.out.println("Please enter a range number:");
//		int end = scanner.nextInt();
//		
//		if(start > end) {
//			int temp = end;
//			end = start;
//			start = temp;
//		}
//		
//		String res = "";
//		if(numCheck < start) {
//			res = "Smaller than ";
//		}else if(numCheck > end){
//			res = "Greater than ";
//		}else {
//			res = "in ";
//		}
//		
//		String finalRes = numCheck +" is " + res + "the range of " + start + " to " + end;
//		System.out.println(finalRes);
		
//		scanner.close();
	}

}
