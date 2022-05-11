package bootcamp.oop.designExercise;

public class Cappuccino extends Coffee {

	public Cappuccino() {
		this(24, 30, 200, 1);
	}

	public Cappuccino(int price, int temp, int volume, int suger) {
		super(price, temp, volume, suger);
		setNumOfShots(2);
	}

	
	@Override
	public void produce() {
		int milkNeeded = volume - numOfShots * SHOTAMOUNT;
		int waterNeeded = numOfShots * SHOTAMOUNT;
		if (VendingMachine.milkQtt >= milkNeeded && VendingMachine.waterQtt >= waterNeeded) {
			VendingMachine.waterQtt -= milkNeeded;
			VendingMachine.milkQtt -= waterNeeded;
			System.out.println(this);
		}else {
			System.out.println("Sorry Not avialbe. Fill water!");
			VendingMachine.isFull = false;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Enjoy your Cappuccino !";
	}
}
