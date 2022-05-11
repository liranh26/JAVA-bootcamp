package bootcamp.oop.strings;

import java.util.Scanner;

public class Runner {

	protected static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		runMenu();

		scanner.close();
		
	}

	
	public static void runMenu() {
		int input;

		do {
			printMenu();

//			input = Integer.parseInt(getWordInput()); 
			input = getIntInput(); 

			switch (input) {
			
			case 1:
				handleQuestion1();
				break;
				
			case 2:
				handleQuestion2();
				break;
				
			case 3:
				handleQuestion3();
				break;
				
			case 7:
				System.out.println("Bye!");
				break;
				
			default:
				System.out.println("Enter a number between 1-7, try again!");
			}

		} while (input != 7);
		
	}

	
	public static String getSentenceInput() {
		String input = scanner.nextLine();  // asdfsadfsd sdasd \n
		return input;
	}

	
	public static int getIntInput() {
		int input = scanner.nextInt(); // 1_\n
		scanner.nextLine();
		return input;
	}

	
	public static String getWordInput() {
		String input = scanner.next(); // asfsadgasdgs\n
		scanner.nextLine(); // \n 
		return input;
	}

	
	public static void handleQuestion1() {
		System.out.println("Please enter the first sentence: ");
		String sen1 = getSentenceInput().trim();
		System.out.println("Please enter the second sentence: ");
		String sen2 = getSentenceInput().trim();
		
		boolean result = isBackwards(sen1, sen2);
		String resText = "is";
		if (!result)
			resText = "is NOT";
		printMsg("The sentence " + resText + " written backwords!");
	}
	
	
	public static boolean isBackwards(String sen1, String sen2) {
		
		if (sen1.length() != sen2.length())
			return false;

		for (int i = 0; i < sen1.length(); i++) {
			if (sen1.charAt(i) != sen2.charAt(sen2.length() - i - 1))
				return false;
		}

		return true;
	}

	
	public static void handleQuestion2() {
		System.out.println("Please enter a word: ");;
//		String input = getWordInput();
		String word = getSentenceInput();
		
		boolean result = isPolindrome(word);
		String resText = "is";
		if (!result)
			resText = "is NOT";
		System.out.println("The sentence " + resText + " a polindrome!");
	}
	
	
	public static boolean isPolindrome(String word) {

		String revWord = "";

		for (int i = word.length() - 1; i >= 0; i--) {
			revWord += word.charAt(i);
		}

		return word.equals(revWord);
	};
	
	
	public static void handleQuestion3() {
		System.out.println("Please enter a sentence: ");
		String sentence = getSentenceInput();
		System.out.println("Please enter a word: ");
		String word = getWordInput();
		
		if(sentence.contains(word)) {
			sentence = sentence.replaceAll(word, "").trim();
			printMsg(sentence);
		}else
			printMsg("The word is NOT part of the sentence!");
		
	}
	

	public static void printMenu() {
		String menuText = "Please enter the number of your selection from the following options: \r \n";
		menuText += "1. Enter 2 sentences and I値l tell you if one is the other written backwards. \r \n";
		menuText += "2. Enter a word and I値l tell you if it is a palindrome.\r \n";
		menuText += "3. Enter a sentence and a word and I値l remove that word from anywhere in the sentence for you.\r \n";
		menuText += "4. Enter a sentence and I値l capitalize the beginning of each word in it.\r \n";
		menuText += "5. Enter a sentence and 2 words and I値l replace that first word with the second from everywhere in the sentence for you. \r \n";
		menuText += "6. Enter a sentence and a letter and I値l print all the words that start with that letter.\r \n";
		menuText += "7. Exit \r \n";
		System.out.println(menuText);
	}
	
	
	public static void printMsg(String msg) {
		System.out.println("msg");
	}
	
	
	
	
//	execp();
 	public static void execp() {

		Scanner scanInput = new Scanner(System.in);
		String input = scanInput.nextLine();
		System.out.println(input);
		
		scanInput.close();
	}

}
