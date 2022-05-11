package bootcamp.oop.designExercise;

public class Espresso extends Coffee{
	
	public Espresso() {
		this(15, 40 , 50, 2, 3);
	}
	
	public Espresso(int price, int temp, int volume, int suger, int numOfShots) {
		super(price, temp, volume, suger);
		setNumOfShots(numOfShots);
	}

	
	@Override
	public void produce() {
		int waterNeeded = numOfShots * SHOTAMOUNT;
		if(VendingMachine.waterQtt > waterNeeded) {
			VendingMachine.waterQtt -= waterNeeded;
			System.out.println(this);			
		}else {
			System.out.println("Sorry not available! Fill water!");
			VendingMachine.isFull = false;
		}
	}
	

	@Override
	public String toString() {
		return  super.toString() + "Enjoy your esspreso !";
	}
	
	
}
