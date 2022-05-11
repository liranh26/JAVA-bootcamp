package bootcamp.oop.designExercise;

enum Container{
	BOTTLE, CAN;
}

public abstract class Soda extends ColdBeverage {

	private Container container;
		
	public Soda(int price, int temp, int volume, String ingredient, Container container) {
		super(price, temp, volume, ingredient);
		this.container = container;
	}


	@Override
	public String toString() {
		return "Enjoy your cold beverage in a "+container+"! \n";
	}
	

}
                 