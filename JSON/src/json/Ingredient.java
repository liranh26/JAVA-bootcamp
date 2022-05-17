package json;

public class Ingredient {
	
	protected String name;
	protected float weight;
	
	public Ingredient() {}
	
	public Ingredient(String name, float weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", weight=" + weight + "]\n";
	}
	
	
}
