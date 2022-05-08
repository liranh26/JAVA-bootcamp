package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Random;

public class AppManager {
	protected Dragon[] dragons;
	protected Food[] foods;

	public AppManager() {
		initializeData();
	}

	protected void initializeData() {
		dragons = new Dragon[2];
		foods = new Food[2];

		dragons[0] = new Dragon("Denver", LocalDate.of(800, 8, 26), 1);
		dragons[1] = new Dragon("BlackWinged", LocalDate.of(500, 1, 1), 10);
		foods[0] = new Food("Koskos", Macronutrients.CarboHydrate, Taste.Umami);
		foods[1] = new Food("Mafrum", Macronutrients.Fat, Taste.Sweet);
	}

	public void run() {
		writeObjects();
		printObjects();
	}

	protected void writeObjects() {
		saveToFileObj();
	}

	protected void printObjects() {
		readObjFromFile();
	}

	protected void writeRandomObj(Object objToWrite) {
		try (FileOutputStream fileOut = new FileOutputStream("myFiles/objFile1.ser");
				// Creates an ObjectOutputStream
				ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {

			objOut.writeObject(objToWrite);
		} catch (FileNotFoundException e) {
			System.out.println(e + ", File not found!");
		} catch (IOException e) {
			System.out.println(e + ", IO exception!");
		}
	}

	protected void saveToFileObj() {
		int option;
		for (int i = 0; i < 2; i++) {
			option = getRandomSize();
			switch (option) {
			case 0:
				writeRandomObj(dragons[0]);
				break;
			case 1:
				writeRandomObj(dragons[1]);
				break;
			case 2:
				writeRandomObj(foods[0]);
				break;
			case 3:
				writeRandomObj(foods[1]);
				break;
			}
		}
	}
	
	public int getRandomSize() {
		Random rand = new Random();
		int subSize = rand.nextInt(4) + 1;
		return subSize;
	}

	private void readObjFromFile() {
		Object objectFromFile = null;
		for (int i = 0; i < 2; i++) {

			try (FileInputStream file = new FileInputStream("myFiles/objFile1.ser");
					// Creates an ObjectOutputStream
					ObjectInputStream obj = new ObjectInputStream(file);) {
				objectFromFile = obj.readObject();
				System.out.println("Object number " + i + " is: " + objectFromFile);
			} catch (FileNotFoundException e) {
				System.out.println(e + ", File not found!");
			} catch (IOException e) {
				System.out.println(e + ", IO exception!");
			} catch (ClassNotFoundException e) {
				System.out.println(e + ", Class not found!");
			}

		}

	}

}
