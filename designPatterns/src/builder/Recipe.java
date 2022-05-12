package builder;

/**
 * Car manual is another product. Note that it does not have the same ancestor
 * as a Car. They are not related.
 */
public class Recipe {

	private final PizzaType pizzaType;
	private final int mozzarela, feta, mushrooms, pineapple;

    public Recipe(PizzaType pizzaType, int mozzarela, int feta, int mushrooms, int pineapple) {
		this.pizzaType = pizzaType;
		this.mozzarela = mozzarela;
		this.feta = feta;
		this.mushrooms = mushrooms;
		this.pineapple = pineapple;
    }

	@Override
	public String toString() {
		return "Recipe [pizzaType=" + pizzaType + ", mozzarela=" + mozzarela + ", feta=" + feta + ", mushrooms="
				+ mushrooms + ", pineapple=" + pineapple + "]";
	}
    
}