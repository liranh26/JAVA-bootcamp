package tcp.exe_JSON;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private static int orderCounter = 1;
	private final int NUM_ORDER;
	private List<Dish> dishes;

	public Order() {
		NUM_ORDER = orderCounter++;
		this.dishes = new ArrayList<Dish>();
	}

	public Order(List<Dish> dishes) {
		NUM_ORDER = orderCounter++;
		this.dishes = dishes;
	}

	public void addDish(Dish dish) {
		dishes.add(dish);
	}

	public int getBill() {
		return dishes.stream().map(d -> d.getPrice()).reduce(0, (a, b) -> a + b);
	}

	@Override
	public String toString() {
		return "Order [NUM_ORDER=" + NUM_ORDER + ", order=" + dishes + "]";
	}

}
