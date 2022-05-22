package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class AppManager {

	public static void savePastry(Pastry pastry) {

		Gson gson = new Gson();
		String pastryJson = gson.toJson(pastry);
		System.out.println("Writing To File: " + pastryJson);
		File file = new File("myFiles/pastryList.json");
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(pastryJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readPastryFile(File file) {

		try (FileReader fileReader = new FileReader(file)) {
			JsonReader jsonReader = new JsonReader(fileReader);

			Gson gson = new Gson();
			Pastry pastry = gson.fromJson(jsonReader, Pastry.class);
			System.out.println(pastry);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void savePastryList(ArrayList<Pastry> pastryList) {

		Gson gson = new Gson();
		String pastryJson = gson.toJson(pastryList);
		System.out.println("Writing To File: " + pastryJson);
		File file = new File("myFiles/pastryList.json");
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(pastryJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readPastryList(File file) {

		try (FileReader fileReader = new FileReader(file)) {
			JsonReader jsonReader = new JsonReader(fileReader);

			Gson gson = new Gson();
			Type gsonType = new TypeToken<ArrayList<Pastry>>(){}.getType();
			ArrayList<Pastry> pastry = gson.fromJson(jsonReader, gsonType);
			System.out.println(pastry);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void savePastryMapToFile(Map<PastryLabel, Pastry> pastrys) {

		Gson gson = new Gson();
		Type gsonType = new TypeToken<HashMap>(){}.getType();
		
		String pastrysString = gson.toJson(pastrys, gsonType);
		System.out.println(pastrysString);
		
		File file = new File("myFiles/pastryList.json");
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(pastrysString);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void readPastryMapFromFile(File file) {

		Map<PastryLabel, Pastry> pastrysMap = new HashMap<>();
		try (FileReader fileReader = new FileReader(file)) {
			JsonReader jsonReader = new JsonReader(fileReader);
		
		Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
		Type gsonType = new TypeToken<HashMap>(){}.getType();
		
		pastrysMap = gson.fromJson(jsonReader, gsonType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(pastrysMap);
	}

}
