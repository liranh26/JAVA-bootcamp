package javabootcamp.basic.exam;

public class Runner {

	public static void main(String[] args) {

		
		// Question 3 - test
		int num1 = 5, num2 = 121, num3 = 3443, num4=123454321, num5 = 123; 
		System.out.println(isPolindrome(num1));
		
		
		// Question 4 - test
		int[] testArr1 = {7, 8, -4};
		int[] testArr2 = {-5, 7, 3, 2};
		int[] concArr = concatedArray(testArr1, testArr2);
		
		for (int i = 0; i < concArr.length; i++) {
			System.out.print(concArr[i]+ " ");
		}
		
		
	}

	
	// Question 1
	//JVM reads the Java bytecode and allows to runs the program at any comp. have the JVM.
	//JRE is the standard kit that acts as a software layer on top of the operating system
	//JDK a core packege that include tools and libraries necessary for developing Java-based software applications
	
	
	// Question 2
	// From the editor Java takes the the source file and then compiles it to a bytecode file this bytecode is interpreted by the JVM

	
	// Question 3
	public static boolean isPolindrome(int num) {
		boolean isPoli = true;
		int numCopy = num, sizeOfNum = 0;
		
		// check the size of the input number && the last digit of the number
		while (numCopy != 0) {
			sizeOfNum++;
			numCopy /= 10;
		}
		
		int endNumIndex = (int)Math.pow(10, sizeOfNum-1);
		
		for (int i = 0; i < sizeOfNum/2; i++) {
			if (num%10 != num/endNumIndex) {
				isPoli = false;
				break;
			}
			num-= (num/endNumIndex)*endNumIndex;
			num/=10;
			endNumIndex/=100;
		}

		return isPoli;
	}


	// Question 4
	
	public static int[] concatedArray(int[] arr1, int[] arr2) {
		int concLength = arr1.length + arr2.length + 2;
		int[] concArr = new int[concLength];
		
		//find the array with the small sum
		int arr1Sum = sumArrValues(arr1);
		int arr2Sum = sumArrValues(arr2);
		
		//Deep copy off the arrays
		if(arr1Sum >= arr2Sum) {
			insertValuesToArray(arr2, concArr, 0);
			insertValuesToArray(arr1, concArr, arr2.length);
		}else {
			insertValuesToArray(arr1, concArr, 0);
			insertValuesToArray(arr2, concArr, arr1.length);
		}
		
		//insert the sum and subtract of summed values
		concArr[concLength-2]=arr1Sum+arr2Sum;
		concArr[concLength-1]=arr1Sum-arr2Sum;
		
		return concArr;
	}
	
	public static int sumArrValues(int[] arr) {
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	public static void insertValuesToArray(int[] arrToAdd, int[] arrToGet,int insertIndex) {
		for (int i = 0; i < arrToAdd.length; i++, insertIndex++) {
			arrToGet[insertIndex] = arrToAdd[i];
		}

	}
	
	
	

}
