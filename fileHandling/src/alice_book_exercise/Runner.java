package alice_book_exercise;

/**
 * @author Liran Hadad
 */
public class Runner {

	public static void main(String[] args) {

		AliceReader alice = new AliceReader();

		System.out.println(
				"Number of lines: " + alice.getLineCounter() + ". \n" + "Number of words: " + alice.getWordCounter());

		System.out.println(alice.getLineFromText(18));

		System.out.println(alice.getWordFromText(578));

	}
}
