package javabootcamp.basic.methods;

import java.lang.Math;

public class Runner {

	public static void main(String[] args) {

//		int exam1 = 92, exam2 = 94, exam3 = 97;

//		printAvergaGrade(exam1, exam2, exam3);

//		int maxGrade=getMax(exam1, exam2, exam3);
//		System.out.println(maxGrade);

//		System.out.println(getMax(exam1,exam2));
//		System.out.println(getMax(exam1,exam2,exam3));

//		System.out.println(10*Math.sin(Math.PI/4));
//		System.out.println("120 degrees in radians is: " + 120*Math.PI/180);
//		System.out.println("e^2.5 = " + Math.exp(2.5));

//		int[] arr = newRandomArray(5);
//		for(int i=0; i<arr.length;i++) {
//			System.out.print(arr[i] + " ");
//		}

		int[] arrTest1 = {1,3,5,4,2};
		int[] arrTest2 = {23,4,6};
		
		sumArraysToLongerArray(arrTest1,arrTest2);
		for (int i = 0; i < arrTest1.length; i++) {
			System.out.print(arrTest1[i] + " ");
		}
	}

	public static void printAvergaGrade(int exam1, int exam2, int exam3) {

		double sum = exam1 + exam2 + exam3;
		double grade = sum / 3;

		System.out.printf("The average is: %.2f", grade);
	}

	public static int getMax(int num1, int num2, int num3) {

		int max = num1;

		if (max < num2) {
			max = num2;
		}
		if (max < num3) {
			max = num3;
		}
		return max;
	}

	public static int getMax(int num1, int num2) {

		int max = num1;

		if (max < num2) {
			max = num2;
		}
		return max;
	}

	public static int[] newRandomArray(int length) {
		int[] arr = new int[length];

		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * 201) - 100;
		}
		return arr;
	}

	
	
	public static int[] newArraySummed(int[] longerArray, int[] shorterArray) {
		int[] result = new int[longerArray.length];
		for (int i = 0; i < shorterArray.length; i++) {
			result[i] = shorterArray[i] + longerArray[i];
		}
		
		for (int i = shorterArray.length; i < longerArray.length ; i++) {
			result[i] = longerArray[i];
		}
		
		return result;
	}

	
	public static int[] summingToLongerArray(int[] longerArray, int[] shorterArray) {
		
		for (int i = 0; i < shorterArray.length; i++) {
			longerArray[i] += shorterArray[i];
		}
		
		return longerArray;
	}
	
	
	
	public static void sumArraysToLongerArray(int[] arr1, int[] arr2) {
		int[] longerArray = arr1, shorterArray = arr2;
		//find the longer array between the two
		if(arr1.length < arr2.length) {
			longerArray = arr2; 
			shorterArray = arr1;
		}
		
		//shallow copy & lossing the original address
		longerArray = newArraySummed(longerArray, shorterArray); //--> NOT changes the original array!

		//shallow copy & changing the original array
		longerArray=arr1;
		longerArray = summingToLongerArray(longerArray, shorterArray);
		
	}


	public static int[] concatArr(int[] arr1, int[] arr2) {
		int concatLength = arr1.length + arr2.length;
		int[] concatedArr= new int[concatLength];
		
		concatedArr = insertValus(concatedArr, arr1, 0);
		concatedArr = insertValus(concatedArr, arr2, arr1.length);
		
		return concatedArr;
	}

	public static int[] insertValus(int[] arrToInsert, int[] arrTorecieveValues,int startingIndex) {
		for(int i=startingIndex; i<arrToInsert.length;i++) {
			arrTorecieveValues[i]=arrToInsert[i];
		}
		
		return arrTorecieveValues;
	}
	
	public static void printArray(int[] arrToPrint) {
		for (int i = 0; i < arrToPrint.length; i++) {
			System.out.println(arrToPrint[i]+ " ");
		}
	}
}
