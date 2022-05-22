package json;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

	public static void main(String[] args) {

		File file = new File(Path.of("myFiles", "pastryList.json").toString());

		/******************   Basic Serialization   ******************/
		List<Ingredient> pizzaIngredients = Arrays.asList(new Ingredient("flour", 1.5f),
				new Ingredient("mozeralla", 0.3f), new Ingredient("tomato sauce", 0.15f));
		Pastry pizza = new Pastry("Pizza", 2500, PastryLabel.DAIRY, pizzaIngredients);

		System.out.println("---------- Save Pastry To JSON File -----------");
		AppManager.savePastry(pizza);
		System.out.println("---------- Read Pastry From JSON File -----------");
		AppManager.readPastryFile(file);


		/******************   Using Collections with JSON files   ******************/
		System.out.println();
		List<Ingredient> steakIngredients = Arrays.asList(new Ingredient("steak", 1f), new Ingredient("pepper", 0.1f),
				new Ingredient("salt", 0.1f));
		Pastry steak = new Pastry("Steak", 2500, PastryLabel.MEAT, steakIngredients);
		
		ArrayList<Pastry> pastrys = new ArrayList<>();
		pastrys.add(steak);
		pastrys.add(pizza);
		
		System.out.println("---------- Save List To JSON File -----------");
		AppManager.savePastryList(pastrys);
		System.out.println("---------- Read List From JSON File -----------");
		AppManager.readPastryList(file);

		System.out.println();
		Map<PastryLabel, Pastry> pastrysMap = new HashMap<>();
		pastrysMap.put(PastryLabel.MEAT, steak);
		pastrysMap.put(PastryLabel.DAIRY, pizza);
		
		System.out.println("---------- Pastrys Map Saved to JSON File -----------");
		AppManager.savePastryMapToFile(pastrysMap);
		System.out.println("---------- Pastrys Map From JSON File -----------");
		AppManager.readPastryMapFromFile(file);

	}

}
