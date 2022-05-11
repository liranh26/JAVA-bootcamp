package javabootcamp.basic.conditions;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

//		// ***** lesson q1 - range of one input between two inputs ******
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
		
		


//		//*** lesson q3 - switch & case ***
//		System.out.println("Enter a year: ");
//		int year = scanner.nextInt();
//		
//		System.out.println("Enter a month number: ");
//		int month = scanner.nextInt();
//		
//		int febDays = 28;
//		int leapYear = 2020;
//		
//		if(year % 4 == 0) {
//			febDays = 29;
//		}
//		
//		if(year < 0) {
//			System.out.println("Invalid year value!");
//			return; // or else
//		}
//		
//		String result = "";
//		
//		switch(month) {
//		
//		case 1: 
//			result = "January " + year + " has 31 days";
//			break;
//			
//		case 2: 
//			result = "February " + year + " has "+ febDays + " days";
//			break;
//			
//		case 3: 
//			result = "March " + year + " has 31 days";
//			break;
//			
//		case 4: 
//			result = "April " + year + " has 30 days";
//			break;	
//			
//		case 5: 
//			result = "May " + year + " has 31 days";
//			break;
//			
//		case 6: 
//			result = "June " + year + " has 30 days";
//			break;
//			
//		case 7: 
//			result = "July " + year + " has 31 days";
//			break;
//			
//		case 8: 
//			result = "August " + year + " has 31 days";
//			break;
//			
//		case 9: 
//			result = "September " + year + " has 30 days";
//			break;
//			
//		case 10: 
//			result = "October " + year + " has 31 days";
//			break;
//			
//		case 11: 
//			result = "November " + year + " has 30 days";
//			break;
//		case 12: 
//			result = "December " + year + " has 31 days";
//			break;
//			
//		default:
//			result = "Invalid month value!";
//		}
//		
//		
//		System.out.println(result);
		
		
		
		
		
		scanner.close();

	}

}
