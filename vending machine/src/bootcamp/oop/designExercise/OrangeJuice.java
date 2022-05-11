package bootcamp.oop.designExercise;

public class OrangeJuice extends SoftDrink {

	public OrangeJuice() {
		this(19, 12, 200, "oranges", SoftDrinkForm.SQEEZED);
	}
	
	public OrangeJuice(int price, int temp, int volume, String ingredient, SoftDrinkForm softDrinkForm) {
		super(price, temp, volume, ingredient, softDrinkForm);
		
	}

	@Override
	public String toString() {
		return super.toString()+"The healthy choise!";
	}
	
}
