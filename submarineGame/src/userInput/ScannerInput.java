package userInput;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
*@author Liran Hadad
*/
public class ScannerInput {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static String getStringFromUser() {
		String str="";
		try {
			while(true) {
				str = sc.nextLine();
				break;
			}
		}catch(NoSuchElementException e) {
			System.out.println(e + ", Try again!");
		}catch(IllegalStateException e) {
			System.out.println(e + ", Try again!");
		}
		return str;
	}
	
	public static void closeScanner() {
		sc.close();
	}

}
