package bootcamp.oop.polymorphism;

public abstract class Delivery {
	private static long counter = 0;
	protected String name;
	protected String address;
	protected final long ID;
	
	public Delivery(String address, String clientName) {
		this.address = address;
		this.name = clientName;
		this.ID = counter++;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("delivery number  #%d for %s at %s \n", ID, name, address);
	}
	
	public void deliver() {
		
	}
	
	
}
