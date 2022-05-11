package bootcamp.oop.designExercise;

enum ChocoBase{
	MILK, WATER;
}

public class Chocolate extends HotBeverage{
	
	private ChocoBase chocoBase; 

	public Chocolate() {
		this(15, 30, 150, 4, ChocoBase.MILK);
	}
	
	public Chocolate(int price, int temp, int volume, int suger, ChocoBase chocoBase) {
		super(price, temp, volume, suger);
		this.chocoBase = chocoBase;
	}


	@Override
	public void produce() {
		
		if(chocoBase == ChocoBase.MILK && this.volume <= VendingMachine.milkQtt) {
			VendingMachine.milkQtt-= this.volume; 
			System.out.println(this);
			
		}else if(chocoBase == ChocoBase.WATER && this.volume <= VendingMachine.waterQtt){
			VendingMachine.waterQtt-= this.volume; 
			System.out.println(this);
			
		}else {
			VendingMachine.isFull = false;
			System.out.println("Sorry not available! Fill water!");
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Enjoy your Hot Chocolate based on "+chocoBase.toString().toLowerCase()+" \n" + "The final price is: "+price;
	}
	
	
	
	
}
