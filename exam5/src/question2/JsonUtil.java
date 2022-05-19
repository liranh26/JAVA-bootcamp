package question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JsonUtil {

	private static ArrayList<ObjectFromJSON> objects = new ArrayList<>();;
	private static final String PATH = "myFiles/Anonymous_File.json";

	public static void deserializeFile() {

		File file = new File(PATH);

		try (FileReader fileReader = new FileReader(file)){
			
			JsonReader jsonReader = new JsonReader(fileReader);

			Gson gson = new Gson();
			Type gsonType = new TypeToken<ArrayList<ObjectFromJSON>>(){}.getType();

			objects = gson.fromJson(jsonReader, gsonType);


			for (ObjectFromJSON object : objects) {
				System.out.println(object);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
	}

}
