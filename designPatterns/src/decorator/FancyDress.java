package decorator;

public class FancyDress extends DressDecorator {

	public FancyDress(Dress dress) {
		super(dress);
	}
	
	@Override
	public void create() {
		super.create();
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Fanciness added...";
	}
	
	
}
