package bootcamp.oop.designExercise;

enum SoftDrinkForm {
	SQEEZED, PASTEURIZED;
}

/**
 * This abstract class constructs the fields for a cold beverage it extends the
 * abstract class ColdBeverage.
 * 
 * @author Liran Hadad
 *
 */

public abstract class SoftDrink extends ColdBeverage {

	private SoftDrinkForm softDrinkForm;

	/**
	 * This constructor receives the following fields and sets values through the
	 * abstract class ColdBeverage constructor, in addition of new field softDrinkForm.
	 * 
	 * @param price      is the price of this beverage by using abstract class
	 *                   Beverage constructor
	 * @param temp       is the required temperature of the beverageby using
	 *                   abstract class Beverage constructor.
	 * @param volume     is amount of the beverage to pour by using abstract class
	 *                   Beverage constructor.
	 * @param ingredient is a string represents the main ingredient flavor of the
	 *                   drink
	 * @param softDrinkForm is the method type for making the drink. 
	 */

	public SoftDrink(int price, int temp, int volume, String ingredient, SoftDrinkForm softDrinkForm) {
		super(price, temp, volume, ingredient);
		this.softDrinkForm = softDrinkForm;

	}

	@Override
	public String toString() {
		return "Enjoy your " + softDrinkForm.toString().toLowerCase() + " soft drink ! \n";
	}

}
