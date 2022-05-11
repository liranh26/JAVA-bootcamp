package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author Liran Hadad
 */
public class Runner {
	public static Scanner sc = new Scanner(System.in);

	public static void readFile(String path) throws FileNotFoundException {
		FileReader file = new FileReader(path);
	}

	public static void main(String[] args) {
//		String path = "myText.txt";
//		try {
//			readFile(path);
//		} catch (FileNotFoundException e) {	
//			e.printStackTrace();
//		}
		int num1 = 100, res;
		System.out.println("Enter a number to divide: ");
		int num2=0;
		boolean valid = false;
		while (!valid) {

			try {
				num2 = getInt();
				
				res = num1 / num2;
				System.out.println("The result is: " + res);
				valid = true;
			}
			catch (ArithmeticException e){
				System.out.println(e+". zero not allowed");
			}
			catch(InputMismatchException err){
				System.out.println(err);
				int num3 = (int)num2;
				System.out.println(num3);
				res = num1 / num2;
				System.out.println("The result is: " + res);
				valid = true;
			}
		}

	sc.close();
	
	}

	private static int getInt() {
		int num2 = sc.nextInt();
		return num2;
	}
	
	
//	} 
//	 catch (ArithmeticException err) {
//		System.out.println(err + ". The value entered cannot be a zero!");
//		continue;
//	} catch (InputMismatchException err) {
//		try {
//			num2 = (int)num2;
//			System.out.println("converted to int! data lost..");
//			
//		}catch (NumberFormatException e) {
//			System.out.println(e + ". The value entered cannot be a char!");
//		}
//	
//	
//}
//}


}
