package builder;

/**
 * Car is a product class.
 */
public class Pizza {
	
	private final PizzaType pizzaType;
	private final int mozzarela, feta, mushrooms, pineapple;

	public Pizza(PizzaType pizzaType, int mozzarela, int feta, int mushrooms, int pineapple) {
		this.pizzaType = pizzaType;
		this.mozzarela = mozzarela;
		this.feta = feta;
		this.mushrooms = mushrooms;
		this.pineapple = pineapple;
	}

	public PizzaType getPizzaType() {
		return pizzaType;
	}

	public int getMozzarela() {
		return mozzarela;
	}

	public int getFeta() {
		return feta;
	}

	public int getMushrooms() {
		return mushrooms;
	}

	public int getPineapple() {
		return pineapple;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaType=" + pizzaType + ", mozzarela=" + mozzarela + ", feta=" + feta + ", mushrooms="
				+ mushrooms + ", pineapple=" + pineapple + "]";
	}
	
	

}