package builder;

/**
 * Concrete builders implement steps defined in the common interface.
 */
public class PizzaBuilder implements Builder {
	private PizzaType type;
	private int mozzarela, feta, mushrooms, pineapple;

	@Override
	public void setPizzaType(PizzaType type) {
		this.type = type;
	}

	@Override
	public void setMozzarela(int mozzarela) {
		this.mozzarela = mozzarela;
	}

	@Override
	public void setFetaCheese(int feta) {
		this.feta = feta;
	}

	@Override
	public void setMushrooms(int mushrooms) {
		this.mozzarela = mushrooms;
	}

	@Override
	public void setPineapple(int pineapple) {
		this.pineapple = pineapple;
	}
	
	public Pizza getResult() {
		return new Pizza(type, mozzarela, feta, mushrooms, pineapple);
	}

}
