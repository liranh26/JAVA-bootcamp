package bootcamp.oop.designExercise;

/**
 * This abstract class c  ontains the basic functionality methods for a hot
 * beverage, it extends the abstract class Beverage.
 * 
 * @author Liran Hadad
 *
 */
public abstract class HotBeverage extends Beverage {

	private final int MAXSUGERSPOONS = 5;
	private final int MINSUGERSPOONS = 0;

	private int numSugar;

	/**
	 * This constructor receives the following fields and sets values through the
	 * abstract class Beverage constructor, in addition of new field sugar.
	 * 
	 * @param price  - is the price of this beverage by using abstract class
	 *               Beverage constructor
	 * @param temp   - is the required temperature of the beverage by using abstract
	 *               class Beverage constructor.
	 * @param volume - is amount of the beverage to pour by using abstract class
	 *               Beverage constructor.
	 * @param suger  - the amount of spoons of sugar to add
	 */
	public HotBeverage(int price, int temp, int volume, int sugar) {
		super(price, temp, volume);
		setNumSugar(sugar);
	}

	/**
	 * 
	 * @returns the number of required spoons of sugar
	 */
	public int getNumSugar() {
		return numSugar;
	}

	/**
	 * This method checks if the sugar input by the user is valid.
	 * 
	 * @param numSugar required by the user.
	 */
	public void setNumSugar(int numSugar) {
		if (numSugar <= MAXSUGERSPOONS && numSugar >= MINSUGERSPOONS)
			this.numSugar = numSugar;
	}

}
