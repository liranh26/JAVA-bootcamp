package files.stream_reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Liran Hadad
 */
public class PrintWriterDemo {

	public static void writerDemo() {

		String data = "This is the data i want to write!\n";
		String data1 = "Adding data";
		int age = 33;
		float monet = 1233.34f;

		try ( PrintWriter printer = new PrintWriter("myFiles/output3.txt") ){
			
			printer.printf("%s age = %d and moner = %.2f", data1, age, monet);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}