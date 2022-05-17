package json;

import java.util.List;

public class Pastry {
	
	protected String name;
	protected int calories;
	protected PastryLabel label;
	protected List<Ingredient> igredients;
	
	public Pastry(String name, int calories, PastryLabel label, List<Ingredient> igredients) {
		this.name = name;
		this.calories = calories;
		this.label = label;
		this.igredients = igredients;
	}

	@Override
	public String toString() {
		return "Pastry [name=" + name + ", calories=" + calories + ", label=" + label + ", igredients=" + igredients
				+ "]\n";
	}
	
}
