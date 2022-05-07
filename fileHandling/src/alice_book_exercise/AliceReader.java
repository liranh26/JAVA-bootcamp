package alice_book_exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Liran Hadad
 */
public class AliceReader {

	int wordCounter = 0, lineCounter = 0;

	public AliceReader() {
		setNumOfWords();
		setNumOfLines();
	}

	protected void setNumOfWords() {
		File file = new File("myFiles/alice.txt");
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNext()) {
				sc.next();
				wordCounter++;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e + ", Could not find the file!");
		}
	}

	protected void setNumOfLines() {
		File file = new File("myFiles/alice.txt");
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				sc.nextLine();
				lineCounter++;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e + ", Could not find the file!");
		}
	}

	public String getLineFromText(int lineNumber) {
		File file = new File("myFiles/alice.txt");
		int lineCounter = 0;
		String input = "";
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				lineCounter++;
				input = sc.nextLine();
				if (lineCounter == lineNumber)
					return input;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e + ", Could not find the file!");
		}
		return null;
	}

	public String getWordFromText(int wordNumber) {
		File file = new File("myFiles/alice.txt");
		int wordCounter = 0;
		String input = "";
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				wordCounter++;
				input = sc.next();
				if (wordCounter == wordNumber)
					return input;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e + ", Could not find the file!");
		}
		return null;
	}

	public int getWordCounter() {
		return wordCounter;
	}

	public int getLineCounter() {
		return lineCounter;
	}

}
