package utils;

import java.util.Random;
import java.util.Scanner;

public class ScannerInputs {
	public static Scanner scanner = new Scanner(System.in);
	
	
	public static int getIntFromUser() {
		int num = ScannerInputs.scanner.nextInt();
		ScannerInputs.scanner.nextLine();
		return num;
	}
	
	public static double getDoubleFromUser() {
		double num = ScannerInputs.scanner.nextDouble();
		ScannerInputs.scanner.nextLine();
		return num;
	}
	
	public static int getAuthNum() {
		Random random = new Random();
		int authCode = random.nextInt(1000, 9999);
		return authCode;
	}
	
	public static String getStringFromUser() {
		String str = ScannerInputs.scanner.next();
		ScannerInputs.scanner.nextLine();
		return str;
	}
	
}
