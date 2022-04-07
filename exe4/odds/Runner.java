package javabootcamp.basic.exe4.odds;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

//		// ******** H.W ex.3.3 - calculating check for wedding *********//
//		
//		int familyRate = 1000, friendRate = 500, minAmount = 250, check=0;
//		System.out.println("Enter the from where you know the couple");
//		System.out.println("1-familyRate , 2-friendRate , 3-Other");
//		int bound = scanner.nextInt();
//		
//		System.out.println("Enter the number of years you know the the groom / bride: ");
//		int yearsKnow = scanner.nextInt();
//		
//		System.out.println("How long is the drive [hours]: ");
//		float hours = scanner.nextFloat();
//		
//		if(hours > 1.0) {
//			check -= 50 ;
//		}
//		if(yearsKnow > 3 && bound != 1) {
//			check += 50;
//		}
//		
//		switch(bound){
//		case 1:
//			check += familyRate;
//			break;
//		case 2:
//			check += friendRate;
//			break;
//		default:
//			check += minAmount;
//		}
//		
//		System.out.println("Your check for the couple is:"+check);

//		// ******** H.W ex.3.7 - student grade *********//
//		
//		int homeWorkGrade, examGrade, numberOfExercises;
//		float finalGrade = 0, exericesFactor=0;
//		final int EXAM_PASS = 55, EXE_PASS=80; 
//		
//		System.out.println("Enter exam grade: ");
//		examGrade = scanner.nextInt();
//		System.out.println("Enter home work grade: ");
//		homeWorkGrade = scanner.nextInt();
//		System.out.println("Enter number of exercise: ");
//		numberOfExercises = scanner.nextInt();
//		
//		switch(numberOfExercises){
//		case 5:
//		case 6:
//			if(examGrade >= EXAM_PASS) {
//				exericesFactor = 0.2f;				
//			}
//			break;
//		case 7:
//		case 8:
//			if(homeWorkGrade < examGrade) {
//				break;
//			}
//			if(examGrade < EXAM_PASS) {
//				if(homeWorkGrade >= EXE_PASS)
//					exericesFactor = 0.25f;
//				else
//					exericesFactor = 0.2f;
//			}else {
//				exericesFactor = 0.3f;
//			}
//			break;
//		}
//		
//		finalGrade = examGrade*(1-exericesFactor) + homeWorkGrade*exericesFactor;
//		
//		System.out.println("Your final grade is: "+ (int)finalGrade);

		// ******** BEGIN CODE - A MESS! ********
//		if(5 <= numExercise && numExercise <= 6) {
//			if(exam < 55) {
//				grade = exam;
//			}else {
//				grade = exam * 0.8 + homeWork * 0.2;
//			}
//		}else if(numExercise > 6) {
//			if(exam < 55) {
//				if(homeWork >= 80) {
//					sheild = homeWork * 0.25;
//					if(exam < (sheild + exam*0.75)) {
//						grade = sheild + exam*0.75;
//					}else {
//						grade = exam;
//					}
//				}else {
//					sheild = homeWork * 0.2;
//					if(exam < (sheild + exam*0.8)) {
//						grade = sheild + exam*0.8;
//					}else {
//						grade = exam;
//					}
//				}
//			}else {
//				sheild = homeWork * 0.3;
//				if(exam < (sheild + exam*0.7)) {
//					grade = sheild + exam*0.7;
//				}else
//					grade = exam;
//			}
//		}
//		
//		System.out.println("Your grade is: " + (int)grade);

//		// ******** Workbook ex.4.2 - *********//
//		
//		int input, digit=1, index=0, result=0, temp;
//		System.out.println("Enter a number: ");
//		input = scanner.nextInt();
//		while (input!=0) {
//			
//			if(index%2==0) {
//				result += (input%10) * digit;
//				digit *= 10;
//			}
//			
//			input /= 10 ;
//			index++;
//		}
//		System.out.println("The new number is: "+result);

		
//		// ******** Workbook ex.4.4 - *********//
//		
//		int sumOfNumbers = 0, switcher = -1, input, productWieght = 2, numberToAdd=0, result=0;
//		System.out.println("Please enter input: ");
//		input = scanner.nextInt();
//		
//		for(int i=0;i<9;i++) {
//			numberToAdd = productWieght*(input%10);
//			if(numberToAdd <9) {
//				sumOfNumbers += numberToAdd;				
//			}else {
//				sumOfNumbers += numberToAdd%10 + numberToAdd/10;	
//			}
//			productWieght += switcher;
//			switcher *= -1;
//			input /= 10;
//		}
//		
//		while(sumOfNumbers%10 != 0) {
//			result++;
//			sumOfNumbers++;
//		}
//		
//		System.out.println("Your number is: "+result);

		// ******** Workbook ex.4.6 - *********//

		int i,input, notEmpty=0, result=0,numLength=0, digit=1, totalDig;
		
		System.out.println("Enter a number: ");
		input = scanner.nextInt();
		notEmpty = input;
		
		while(notEmpty!=0) {			
			digit *= 10;
			notEmpty /= 10 ;
			numLength++;			
		}
		
		result = digit*input;
		
		for(i=0; i<numLength;i++) {
			digit/=10;
			result += (input%10)*digit;
			input/=10;
		}
//		
//		System.out.println(result);

//		// ******** Workbook ex.4.8 - *********//  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//		float singleNumerator,singleDenominator,doubleNumerator,doubleDenominator;
////		int singleNumerator = scanner.nextInt();
////		int singleDenominator =scanner.nextInt();
////		
////		int doubleNumerator = scanner.nextInt();
////		int doubleDenominator =scanner.nextInt();
//		
//		for(int i=1;i<10;i++) {
//			for(int ) {
//				
//			}
//		}

		
//		// ******** Workbook ex.4.10 - *********//             
//		int numCopy,result=0,digit=1,resDigit=1,numLength=0,numberToAdd,numberDivided,temp;
//		System.out.println("Enter a number: ");
//		int numInput = scanner.nextInt();
//		System.out.println("Enter a divder");
//		int numDivider = scanner.nextInt();
//		
//		numCopy = numInput;
//		while(numCopy!=0) {			
//			numCopy /= 10 ;
//			numLength++;			
//		}
//		
//		for(int i=0;i<numDivider;i++) {
//			digit*=10;
//		}
//		
//		numCopy = numInput;
//
//		for(int i=1; i<=numLength;i++) {
//			numberDivided = numCopy%digit;
//			temp = digit;
//			
//			for(int j=1; j<=numDivider && numberDivided > numDivider; j++) {
//				digit/=10;
//				numberToAdd = numberDivided/digit;
//				numberDivided%=digit;
//				
//				result+=numberToAdd*resDigit;
//				resDigit*=10;
//			}
//			
//			digit=temp;
//			numCopy/=digit;
//		}
//		
//		System.out.println(result);

		
//		//******** Workbook ex.4.12 - stars triangle *********//
//		int temp;
//		int input = scanner.nextInt();
//		temp = input;
//		for(int i=0; i<input; i++) {
//			for(int j=1; j<=temp;j++) {
//				System.out.print("* ");
//			}
//			temp--;
//			System.out.println();
//			for(int j=0;j<=i;j++) {
//				System.out.print(" ");
//			}
//		}

		
//		// ******** Workbook ex.4.14 - stars square *********//
//		
//		boolean blank=false;
//		int rowLength, colIndex = 0, blankIndex = 1;
//		int input = scanner.nextInt();
//
//		rowLength = input * input + input - 1;
//		blankIndex = input;
//		for (int i = 0; i < rowLength; i++) {
//			System.out.println();
//			if(blankIndex == i) {
//				blank = true;
//				blankIndex+=input+1;
//			}else {
//				blank = false;
//			}
//			for (int j = 0; j < rowLength; j++) {
//				if(!blank) {
//					if (colIndex != input) {
//						System.out.print("*");
//						colIndex++;
//					} else {
//						System.out.print(" ");
//						colIndex = 0;
//					}				
//				}else {
//					System.out.print(" ");
//				}
//			}
//			colIndex = 0;
//				
//		}

//		// ******** Workbook ex.4.16 - *********//   
//
//		int i = 0, numToCompare, sum, prevNum=0;
//		int num = 220; // first number
//		
//		while (i < 10) {
//			numToCompare = 0;
//			sum = 0;
//
//			// find first number dividers
//			for (int j = 1; j < num; j++) {
//				if (num % j == 0) {
//					sum += j;
//				}
//			}
//			
//			// find the dividers of sum
//			for (int j = 1; j < sum; j++) {
//				if (sum % j == 0) {
//					numToCompare += j;
//				}
//			}
//			
//			if (num == numToCompare && num != sum && num != prevNum) {
//				prevNum = sum;
//				System.out.println("The numbers " + num + " and " + sum + " are friends!");
//				i++;
//			}
//			num++;
//
//		}

		scanner.close();

	}

}
