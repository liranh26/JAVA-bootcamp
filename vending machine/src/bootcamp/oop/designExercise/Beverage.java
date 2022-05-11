package bootcamp.oop.designExercise;

/**
 * This abstract class contains the basic functionality methods for a beverage
 * in a vending machine. it sets basic fields of price in Shekles, tempreture in
 * Celsius and volume at cubic meter.
 * 
 * @author Liran Hadad
 *
 */
public abstract class Beverage implements Produceable {
	// fields
	protected int price;
	protected int temperature;
	protected int volume;

	/**
	 * The constructor sets params for the fields of the beverage.
	 * 
	 * @param price  - is the price of this beverage.
	 * @param temp   - is the required temperature of the beverage.
	 * @param volume - is amount of the beverage to pour.
	 */
	public Beverage(int price, int temp, int volume) {
		setPrice(price);
		setTempreture(temp);
		setVolume(volume);
	}

	/**
	 * This method gets the price of the beverage
	 * 
	 * @return the price of this beverage.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * This method sets the price of the beverage
	 * 
	 * @param price is received from the user.
	 */
	private void setPrice(int price) {
		this.price = price;
	}

	/**
	 * This method gets desired the temperature of the beverage
	 * 
	 * @return the desired temperature of the beverage.
	 */
	public int getTempreture() {
		return temperature;
	}

	/**
	 * This method sets desired temperature of the beverage
	 * 
	 * @param tempreture the desired temperature.
	 */
	private void setTempreture(int tempreture) {
		this.temperature = tempreture;
	}

	/**
	 * This method gets the desired volume of the beverage.
	 * 
	 * @return the desired volume of the beverage.
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * This method sets desired volume of the beverage
	 * 
	 * @param volume the desired volume.
	 */
	private void setVolume(int volume) {
		this.volume = volume;
	}

}
