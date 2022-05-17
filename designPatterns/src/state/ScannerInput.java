package state;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerInput {

	public static Scanner sc = new Scanner(System.in);

	public static String getStringFromUser() {
		String str = "";
		try {
			while (true) {
				str = sc.nextLine();
				break;
			}
		} catch (NoSuchElementException e) {
			System.out.println(e + ", Try again!");
		} catch (IllegalStateException e) {
			System.out.println(e + ", Try again!");
		}
		return str;
	}

	public static int getIntFromUser() {
		int num = -1;
		boolean success = false;
		while (true) {
			try {
				String input = sc.next();
				num = Integer.parseInt(input);
				success = true;
			} catch (NumberFormatException e) {
				// float parsing
				try {
					String msg = e.getMessage();
					int start = msg.indexOf('\"') + 1;
					int end = start + msg.substring(start).indexOf('\"');
					num = (int) Float.parseFloat(msg.substring(start, end));
					success = true;
				} catch (NumberFormatException ne) {
					System.out.println(ne + "\n Input can't be parsed - Try again");
				}
			}
			// if input is valid calculate division
			if (success) {
				return num;
			}
		}
	}

	public static void closeScanner() {
		sc.close();
	}
	
}
