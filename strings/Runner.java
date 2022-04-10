package bootcamp.oop.strings;

import java.util.Scanner;

public class Runner {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		runMenu();

		scanner.close();
	}

	public static void runMenu() {
		String resText;
		boolean result;
		int input;

		do {
			printMenu();

			input = Integer.parseInt(getWordInput()); 
//			input = getIntInput(); 

			switch (input) {
			
			case 1:
				result = isBackwards();
				resText = "is";
				if (!result)
					resText = "is NOT";
				System.out.println("The sentence " + resText + " written backwords!");
				break;
				
			case 2:
				result = isPolindrome();
				resText = "is";
				if (!result)
					resText = "is NOT";
				System.out.println("The sentence " + resText + " a polindrome!");
				break;
				
			case 3:
				removeWord();
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
		String input = scanner.nextLine();
		return input;
	}

	
	public static int getIntInput() {
		int input = scanner.nextInt();
		return input;
	}

	
	public static String getWordInput() {
		String input = scanner.next();
		scanner.nextLine();
		return input;
	}

	
	public static boolean isBackwards() {
		
		System.out.println("Please enter the first sentence: ");
		String sen1 = getSentenceInput().trim();
		System.out.println("Please enter the second sentence: ");
		String sen2 = getSentenceInput().trim();

		if (sen1.length() != sen2.length())
			return false;

		for (int i = 0; i < sen1.length(); i++) {
			if (sen1.charAt(i) != sen2.charAt(sen2.length() - i - 1))
				return false;
		}

		return true;
	}

	
	public static boolean isPolindrome() {

		System.out.println("Please enter a word: ");
//		String input = getWordInput();
		String input = getSentenceInput();
		String revInput = "";

		for (int i = input.length() - 1; i >= 0; i--) {
			revInput += input.charAt(i);
		}

		return input.equals(revInput);
	};
	
	
	public static void removeWord() {
		System.out.println("Please enter the first sentence: ");
		String sentence = getSentenceInput();
		System.out.println("Please enter a word: ");
		String word = getWordInput();
		
		if(sentence.contains(word)) {
			sentence = sentence.replaceAll(word, "").trim();
			System.out.println(sentence);
		}else
			System.out.println("The word is NOT part of the sentence!");
		
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

}
