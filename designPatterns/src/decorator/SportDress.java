package decorator;

public class SportDress extends DressDecorator {

	public SportDress(Dress dress) {
		super(dress);
	}

	@Override
	public void create() {
		super.create();
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Sportiness added...";
	}
	
	
	
}
