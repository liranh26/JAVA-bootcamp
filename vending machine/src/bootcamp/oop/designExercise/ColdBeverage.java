package bootcamp.oop.designExercise;

/**
 * This abstract class contains the basic functionality methods for a cold
 * beverage. it extends the abstract class Beverage.
 * 
 * @author Liran Hadad
 *
 */
public abstract class ColdBeverage extends Beverage {

	private String ingredient;

	/**
	 * This constructor receives the following fields and sets values through the
	 * abstract class Beverage constructor, in addition of new field ingredient.
	 * 
	 * @param price      - is the price of this beverage by using abstract class
	 *                   Beverage constructor
	 * @param temp       - is the required temperature of the beverageby using
	 *                   abstract class Beverage constructor.
	 * @param volume     - is amount of the beverage to pour by using abstract class
	 *                   Beverage constructor.
	 * @param ingredient - is a string represents the main ingredient flavor of the
	 *                   drink
	 */
	public ColdBeverage(int price, int temp, int volume, String ingredient) {
		super(price, temp, volume);
		setIngredient(ingredient);
	}

	/**
	 * 
	 * @returns the main ingredient of the beverage.
	 */
	public String getIngredient() {
		return ingredient;
	}

	/**
	 * sets the main ingredient of the beverage.
	 * @param ingredient - the main ingredient of the beverage.
	 */
	private void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	/**
	 * This method provides the drink for the user according the desired volume of the beverage.
	 * In addition it subtracts the volume amount from the vending machine water tank.  
	 */
	@Override
	public void produce() {
		if (VendingMachine.waterQtt >= volume) {
			VendingMachine.waterQtt -= volume;
			System.out.println(this);
		} else {
			System.out.println("Sorry not available! Fill water!");
			VendingMachine.isFull = false;
		}

	}

}
