package decorator;

public class BasicDress implements Dress {

	protected String color;
	protected char size;
	
	public BasicDress(String color, char size) {
		this.color = color;
		this.size = size;
	}

	@Override
	public void create() {
		System.out.println(this);
		
	}

	@Override
	public String toString() {
		return "BasicDress features color=" + color + ", size=" + size + ".";
	}
	
}
