package exceptions;

public class NonCapatilizedException extends Exception {
	
	private static final long serialVersionUID = -476005233952990724L;
	private String name;

	public NonCapatilizedException() {
		super();
		setName("Name doesn’t start with a capital letter");
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
