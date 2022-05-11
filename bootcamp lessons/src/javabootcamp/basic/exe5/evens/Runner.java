package javabootcamp.basic.exe5.evens;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);


//		// q1
//		String arraysMatch = " opsite";
//		int[] arr1 = new int[5], arr2 = new int[5];
//
//		System.out.println("First array: ");
//		for (int i = 0; i < arr1.length; i++) {
//			arr1[i] = scanner.nextInt();
//		}
//
//		System.out.println("Second array: ");
//		for (int i = 0; i < arr2.length; i++) {
//			arr2[i] = scanner.nextInt();
//		}
//
//		for (int i = 0, j = arr2.length - 1; i < arr1.length; i++, j--) {
//			if (arr1[i] != arr2[j]) {
//				arraysMatch = " not opsite";
//				break;
//			}
//		}
//		System.out.println("Arrays are" + arraysMatch);
		
		

//		//q3
//		
//		int[] array = new int[10];
//		System.out.println("Enter first numbers: ");
//		for (int i = 0; i < 2; i++) {
//		array[i] = scanner.nextInt();
//		}
//		
//		for(int i=2; i<array.length-1; i++) {
//			array[i] = array[i-1] + array[i-2];
//		}
//			
//		for(int i=0; i<array.length; i++) {
//			System.out.print(array[i]+" ");
//		}

		
		
		
		
//		// q5
//		boolean isMatch = true;
//		int[] arr1 = new int[3], arr2 = new int[3];
//		
//		int[] arr1 = {1,4,2} , arr2 = {2,1,4};
//		int arraysLength = arr1.length;
//		
//		for(int i=0; i < arraysLength; i++) {
//			int j = (i + 1) % arraysLength;
//			if(arr2[j] != arr1[i]) {
//				isMatch = false;
//				break;
//			}
//		}
//
//		System.out.println(isMatch);
		
		
		
		

//		//q7
//		
//		int[] arr1 = new int[5], arr2 = new int[5], result = new int[5];
//		int arraysLength = arr1.length, resIndex=0;
//		
//		System.out.println("First array: ");
//		for (int i = 0; i < arraysLength; i++) {
//			arr1[i] = scanner.nextInt();
//		}
//		System.out.println("Second array: ");
//		for (int i = 0; i < arraysLength; i++) {
//			arr2[i] = scanner.nextInt();
//		}
//		
//		for(int i=0;i<arraysLength;i++) {
//			for(int j=0; j<arraysLength; j++) {
//				if(arr1[i] == arr2[j]) {
//					result[resIndex]=arr1[i];
//					resIndex++;
//				}
//			}
//		}
//		
//		System.out.println("The number of matching values is: " + resIndex);
		
		
		
		

		//q9
		

//		int[] arr1 = new int[5], arr2 = new int[5], result = new int[5];
//		int arraysLength = arr1.length, sumNumbersArray1=0, sumNumbersArray2 = 0;
//		
//		System.out.println("First array: ");
//		for (int i = 0; i < arraysLength; i++) {
//			arr1[i] = scanner.nextInt();
//		}
//		System.out.println("Second array: ");
//		for (int i = 0; i < arraysLength; i++) {
//			arr2[i] = scanner.nextInt();
//		}
//		
//		for(int i=0;i<arraysLength ;i++) {
//			while(arr1[i] != 0 || arr2[i] != 0) { 
//				sumNumbersArray1 += arr1[i]%10;
//				sumNumbersArray2 += arr2[i]%10;
//				
//				arr1[i] /= 10;
//				arr2[i] /= 10;
//			}
//			if(sumNumbersArray1 == sumNumbersArray2) {
//				System.out.println("The sum is: "+sumNumbersArray1+" match at " + (i+1));
//			}else {
//				System.out.println("The array numbers doesnt match at " + (i+1));
//
//			}
//			sumNumbersArray1 = sumNumbersArray2 = 0;
//		}
		
		
		

		
		

//		// q11
//		boolean isValid = false;
//		int[][] array = new int[10][10];
//		int[] input = new int[100];
//		int rows = 0, cols = 0, inputIndex=0, biggestNumber=0;
//
//		while (!isValid) {
//			System.out.print("Enter rows: ");
//			rows = scanner.nextInt();
//			if (rows > 0 && rows < 11) {
//				isValid = true;
//			} else {
//				System.out.println("");
//				System.out.print("Value should be between 1-10, try again--> ");
//			}
//		}
//		
//		isValid = false;
//		while (!isValid) {
//			System.out.print("Enter cols: ");
//			cols = scanner.nextInt();
//			if (cols > 0 && cols < 11) {
//				isValid = true;
//			} else {
//				System.out.println("");
//				System.out.print("Value should be between 1-10, try again--> ");
//			}
//		}
//		
//		
//		System.out.println("Enter "+rows*cols+" numbers:");
//		for(int i=0; i< rows*cols; i++) {
//			input[i] = scanner.nextInt();
//		}
//		
//		System.out.println("The matrix is:");
//		for(int i=0; i< rows; i++) {
//			for(int j=0; j< cols; j++) {
//				array[i][j] = input[inputIndex];
//				inputIndex++;
//				System.out.print(array[i][j]+ "   ");
//				if((i==0 || i == rows-1 || j==0 || j== cols-1) && (array[i][j]>biggestNumber)) {
//					biggestNumber = array[i][j];
//				}
//			}
//			System.out.println("");
//		}
//		
//		System.out.println("The max is "+biggestNumber);
//		

		
		
		
		
		
//		// q15
//		boolean isFolded = true;
//		int sizeOfMatrix;
//		
//		System.out.println("Enter matrix size: ");
//		sizeOfMatrix = scanner.nextInt();
//				
//		int[][] array = new int[sizeOfMatrix][sizeOfMatrix];
//		
//		System.out.println("Enter " +sizeOfMatrix*sizeOfMatrix + " values for matrix: ");
//		for (int i = 0; i < sizeOfMatrix; i++) {
//			for (int j = 0; j < sizeOfMatrix; j++) {
//				array[i][j] = scanner.nextInt();
//			}
//		}
//
//		for (int i = 0; i < sizeOfMatrix; i++) {
//			for (int j = 0; j < sizeOfMatrix && i != j; j++) {
//				if (array[i][j] != array[j][i]) {
//					isFolded = false;
//					break;
//				}
//			}
//		}
//
//		System.out.println(isFolded);

		

		scanner.close();

	}

}




