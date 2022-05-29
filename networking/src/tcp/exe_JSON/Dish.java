package tcp.exe_JSON;

public class Dish {
	private String name;
	private int price;
	
	public Dish(String name, int price) {
		this.name = name;
		this.price = price;
	}

	
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Dish name=" + name + ", price=" + price + ".\n";
	}	
	
}
