package files.reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Liran Hadad
 */
public class ReaderWriter {

	public static void writerDemo() {

		String data = "This is the data i want to write!\n";
		String data1 = "Adding data";

		try {
			Writer output = new FileWriter("myFiles/output.txt");

			output.write(data);
//			output.write('9');
			output.append(data1);

			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readerDemo() {
		char[] array = new char[100];

		try {
			Reader input = new FileReader("myFiles/input.txt");

			System.out.println("Is the data available in the strem? " + input.ready());

			input.read(array); // reads from the file and enters it to the char array
			input.close();
			
			System.out.println(array);

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}