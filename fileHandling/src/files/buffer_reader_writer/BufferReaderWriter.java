package files.buffer_reader_writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Liran Hadad
 */
public class BufferReaderWriter {
	
	public static void readerDemo() {
		char[] array = new char[10000];

		try (FileReader file = new FileReader("myFiles/input1.txt");
				BufferedReader input = new BufferedReader(file)){
	

			System.out.println("Is the data available in the strem? " + input.ready());

			input.read(array); // reads from the file and enters it to the char array
			
			System.out.println(array);

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void writerDemo() {

		String data = "This is the data i want to write!\n";
		String data1 = "Adding data";

		try (FileWriter file = new FileWriter("myFiles/outpu2.txt", true);
				BufferedWriter output = new BufferedWriter(file)){
		

//			output.write(data);
			output.append(data1);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}