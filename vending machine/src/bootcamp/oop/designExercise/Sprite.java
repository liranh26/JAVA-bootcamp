package bootcamp.oop.designExercise;

public class Sprite extends Soda{
	
	public Sprite() {
		this(10, 10, 200, "lemons", Container.CAN);
	}
	
	public Sprite(int price, int temp, int volume, String ingredient, Container container) {
		super(price, temp, volume, ingredient, container);
		
	}
	
	@Override
	public String toString() {
		return super.toString()+"Sprite refresh your senses!";
	}
	
}
