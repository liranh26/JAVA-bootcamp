package bootcamp.oop.designExercise;

public class Latte extends Coffee{
	
	public Latte() {
		this(21, 40, 150, 0);
	}
	
	public Latte(int price, int temp, int volume, int suger) {
		super(price, temp, volume, suger);
		setNumOfShots(1);
	}

	@Override
	public void setNumOfShots(int numOfShots) {
		this.numOfShots = numOfShots;
		
	}

	@Override
	public void produce() {
		int milkNeeded = volume - numOfShots * SHOTAMOUNT;
		int waterNeeded = numOfShots * SHOTAMOUNT;
		if(VendingMachine.milkQtt >= milkNeeded && VendingMachine.waterQtt >= waterNeeded) {
			VendingMachine.waterQtt -= waterNeeded;
			VendingMachine.milkQtt -= milkNeeded;
			System.out.println(this);
		}else {
			System.out.println("Fill the machine!");
			VendingMachine.isFull = false;
		}
		
	}

	@Override
	public String toString() {
		return  super.toString() + "Enjoy your latte !";
	}
	
	
	
}
