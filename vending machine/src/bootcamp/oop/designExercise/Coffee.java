package bootcamp.oop.designExercise;
/**
 * This abstract class contains the basic functionality methods for a coffee
 * beverage, it extends the abstract class HotBeverage.
 * 
 * @authr Liran Hadad
 *
 */
public abstract class Coffee extends HotBeverage{
	
	public int numOfShots;
	protected final int SHOTAMOUNT = 50;

	/**
	 * This constructor receives the following fields and sets values through the
	 * abstract class HotBeverage constructor.
	 * 
	 * @param price  - is the price of this beverage by using abstract class
	 *               Beverage constructor
	 * @param temp   - is the required temperature of the beverage by using abstract
	 *               class Beverage constructor.
	 * @param volume - is amount of the beverage to pour by using abstract class
	 *               Beverage constructor.
	 * @param suger  - the amount of spoons of sugar to add.
	 */
	public Coffee(int price, int temp, int volume, int suger) {
		super(price, temp, volume, suger);
		
	}
	
/**
 * This methods returns the number of shots the user desire.
 * @return return the number of shots to produce.
 */
	public int getNumOfShots() {
		return numOfShots;
	}

/**
 * This method checks valid input and sets the number of shots.
 * 
 * @param numOfShots the number of desired shots.
 */
	public void setNumOfShots(int numOfShots) {
		if(numOfShots < 4 && numOfShots > 0) {
			this.numOfShots = numOfShots;
		}
		else {
			System.out.println("The number is not valid");
			this.numOfShots = 0;
			
		}
	}
	

	@Override
	public String toString() {
		return "Your Coffee with number of shots: " + numOfShots + " , and number of suger :"
				+ getNumSugar() + ", its  a total price of: " + getPrice() + "\n";
	}

}
