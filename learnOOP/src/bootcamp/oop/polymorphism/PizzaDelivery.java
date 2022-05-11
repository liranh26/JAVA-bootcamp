package bootcamp.oop.polymorphism;

public class PizzaDelivery extends Delivery{
	
	protected String description;
	
	public PizzaDelivery(String address, String clientName) {
		super(address, clientName);
	}
	
	public float bill() {
		return 1f;
	}

	@Override
	public String toString() {
		return super.toString() + "Total of ";
	}
	
	
	
	
}
