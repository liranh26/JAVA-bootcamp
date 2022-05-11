package bootcamp.oop.designExercise;

public class AppleJuice extends SoftDrink{
	
	public AppleJuice() {
		this(19, 12, 200, "oranges", SoftDrinkForm.SQEEZED);
	}
	
	public AppleJuice(int price, int temp, int volume, String ingredient, SoftDrinkForm softDrinkForm) {
		super(price, temp, volume, ingredient, softDrinkForm);
		
	}

	@Override
	public String toString() {
		return super.toString()+"The tasty choise!!";
	}
}
