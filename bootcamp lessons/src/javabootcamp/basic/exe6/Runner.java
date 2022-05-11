package javabootcamp.basic.exe6;

public class Runner {

	public static void main(String[] args) {
		
//		//***** q1 test *****
//		System.out.println(incrementDigitsByOne(1269));

//		//***** q2 test *****
//		System.out.println(checkNumberLength(581, 123));
		
//		//***** q3 test *****
//		for(int i=1;i<10000;i++) {
//			if(isPerfect(i))
//				System.out.println("The number "+ i +" is Perfect" );			
//		}

//		//***** q4 test *****
//		int[] arrTest = {1, 10, 2, 10, 4};
//		System.out.println( getAmountOfTens(arrTest, 5) ); 
		
//		//***** q5 test *****
//		printRhombus(6,'#');
		
//		//***** q6 test *****
//		int[][] testMatrix = {{2,1,5},{6,7,3},{0,8,0}};
//		 System.out.println(isMatrixSoduko(testMatrix));		
		
		
//		//***** q7 test *****
//		int[][] testMatrix = {{2,1,5,1,2}, {6,7,3,7,6}, {0,8,0,8,0}};
//		System.out.println(isMatrixMirrored(testMatrix));
		
//		//***** q8 test *****
//		int[] testArray1 = {1,2,3,4}, testArray2= {9,7};
//		int[] result = mergeArrays(testArray1, testArray2);
//		for(int i=0; i<result.length;i++) {
//			System.out.print(result[i]+ " ");
//		}
		
//		//***** q9 test *****
		int[][] testMatrix = {{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {0,0,0,0,0}, {0,0,0,0,0}};
		System.out.println(maxZeroRectangle(testMatrix));
	}
	
	//***** H.W. ex 6.1 *****
	public static int incrementDigitsByOne(int num) {
		int digit = 1, incermentDigit, result = 0;

		while (num != 0) {
			incermentDigit = num % 10;
			if (incermentDigit != 9) {
				result += (incermentDigit + 1) * digit;
			}

			digit *= 10;
			num /= 10;
		}

		return result;
	}
	
	//***** H.W. ex 6.2 *****
	public static int checkNumberLength(int num1, int num2) {
		int result = 0, digit1, digit2, resDigit = 1;

		while (true) {
			if (num1 == 0 && num2 == 0) {
				break;
			} else if (num1 == 0 || num2 == 0) {
				result = -1;
				break;
			}
			// get the first digit of each number
			digit1 = num1 % 10;
			digit2 = num2 % 10;

			result += getSmallerNumber(digit1, digit2) * resDigit;
			// advance indexes
			resDigit *= 10;
			num1 /= 10;
			num2 /= 10;
		}

		return result;
	}

	public static int getSmallerNumber(int num1, int num2) {
		if (num1 >= num2)
			return num2;
		else
			return num1;
	}

	//***** H.W. ex 6.3 *****
	public static boolean isPerfect(int num) {
		boolean isPerfect=true;
		int dividersSum=0;
		for(int i=1; i<num; i++) {
			if(num%i == 0) {
				dividersSum += i;
			}
		}
		
		if(dividersSum != num) 
			isPerfect = false;
		
		return isPerfect;
	}
	
	
	//***** H.W. ex 6.4 *****
	public static int getSumOfDigits(int num) {
		int sum=0;
		while(num!=0) {
			sum += num%10;
			num/=10;
		}
		
		return sum;
	}
	
	public static int getAmountOfTens(int[] arr, int length) {
		int sumOfTens = 0;
		for(int i=0; i<length; i++) {
			if(arr[i]==10) {
				sumOfTens++;
			}
		}
		
		return sumOfTens;
	}
	
	
	
	//***** H.W. ex 6.5 *****
	public static void printRhombus(int num, char label) {
		
		for(int i=0; i<num; i++) {
			printRhombusRow(num, i, label);
			System.out.println();
		}
	
		for(int i=num-1; i>=0; i--) {
			printRhombusRow(num, i, label);
			System.out.println();
		}
		
	}
	
	public static void printRhombusRow(int num, int index, char label) {
		for(int j=0; j<num-index; j++) {
			System.out.print(label);				
		}
		for(int j=0; j<index*2;j++) {
			System.out.print(" ");
		}
		for(int j=0; j<num-index; j++) {
			System.out.print(label);				
		}
	}
	
	
	//***** H.W. ex 6.6 *****
	public static boolean isMatrixSoduko(int[][] matrix) {
		boolean isSoduko = true;
		int sumRow, sumCol;
		for(int i=0; i<matrix.length;i++) {
			sumRow = sumCol = 0;
			for(int j=0; j<matrix.length;j++) {
				sumRow += matrix[i][j];
				sumCol += matrix[j][i];
			}
			if(sumRow!=sumCol) {
				isSoduko = false;
				break;
			}
		}
		
		return isSoduko;
	}
	
	
	//***** H.W. ex 6.7 *****
	public static boolean isMatrixMirrored(int[][] matrix) {
		boolean isMirrored = true;
		int Rowlength = matrix[0].length;
		
		for(int i=0; i <matrix.length; i++) {
			for(int j=0; j<Rowlength/2;j++) {
				if(!isNumsEqual(matrix[i][j], matrix[i][Rowlength-j-1])) {
					isMirrored = false;
					break;
				}
			}
		}
		
		return isMirrored;
	}
	
	
	public static boolean isNumsEqual(int num1, int num2) {
		return num1==num2;
	}
	
	
	
	
	//***** H.W. ex 6.8 *****
	public static int[] mergeArrays(int[] arr1, int[] arr2) {
		
		int sumArr1 = sumOfArrayCells(arr1);
		int sumArr2 = sumOfArrayCells(arr2);
		
		int resultSum = sumArr1 + sumArr2;
		int arrResLength = lengthOfNumber(resultSum);
		
		int[] result = new int[arrResLength];
		result = insertNumToCells(result,resultSum);
		
		return result;
	}
	
	public static int sumOfArrayCells(int[] arr) {
		int sum=0,digit=1;
		for(int i=arr.length-1;i>=0;i--) {
			sum+= arr[i]*digit;
			digit*=10;
		}
		return sum;
	}
	
	public static int lengthOfNumber(int num) {
		int length=0;
		while(num!=0) {
			length++;
			num/=10;
		}
		return length;
	}
	
	public static int[] insertNumToCells(int[] arr, int num) {
		
		for(int i=arr.length-1;i>=0;i--) {
			arr[i] = num%10;
			num/=10;
		}
		
		return arr;
	}
	
	
	//***** H.W. ex 6.9 *****
	public static int maxZeroRectangle(int[][] matrix) {
		int result=0;
		for(int i=0;i<matrix.length;i++) {
			//check diagonal
			if(!isZero(matrix[i][i])) {
				return result;
			}
			
			//check up & right cells (not include diagonal)
			if(!isRowZeros(matrix[i],i)) {
				return result;
			}
			
			//check down & left cells (not include diagonal)
			for(int j=i+1;j<matrix.length-1;j++) {
				if(!isZero(matrix[i][j])) {
					return result;
				}
			}
			result++;
		}
		
		return result;
	}
	
	public static boolean isRowZeros(int[] arr, int index) {
		for(int i=0;i<arr.length && i!=index;i++) {
			if(!isZero(arr[i])) {
				return false;
			}
		}
		return true;
	}

	
	public static boolean isZero(int num) {
		return num==0;
	}
	
	
	
	//***** H.W. ex 6.11 *****
	public static void murblePuzzle(char[] puzzle, char zero, char x,int spaceIndex) {
		boolean isDone=false;
		while(isDone) {
			//game plan
			//if 2 left = x -> jump right ->start over
			//if 2 right = o -> jump left ->start over
			//if both sides x -> swap right -> start over
			//if both sidex 0 -> swap left -> start over
			

			
			
		}

	}
	
	
//	public static print 

}



