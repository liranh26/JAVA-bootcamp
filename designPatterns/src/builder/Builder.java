package builder;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
	void setPizzaType(PizzaType type);

	void setMozzarela(int mozzarela);

	void setFetaCheese(int feta);

	void setMushrooms(int mushrooms);

	void setPineapple(int pineapple);

}
