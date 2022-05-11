package bootcamp.oop.designExercise;

public class Cola extends Soda{
	
	public Cola() {
		this(10, 10, 200, "coca leaf", Container.BOTTLE);
	}
	
	public Cola(int price, int temp, int volume, String ingredient, Container container) {
		super(price, temp, volume, ingredient, container);
		
	}


	@Override
	public String toString() {
		return super.toString()+"Cola the taste of life!";
	}
	

	
}
