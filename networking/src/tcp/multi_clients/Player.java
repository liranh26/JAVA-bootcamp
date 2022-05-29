package tcp.multi_clients;

public class Player {
	
	private static int counter = 0;
	private final int id;

	Player() {
		this.id = ++counter;
	}

	public int getId() {
		return id;
	}
	
	
}
