package decorator;

public class CasualDress extends DressDecorator {

	public CasualDress(Dress dress) {
		super(dress);
	}

	@Override
	public void create() {
		super.create();
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Casuality added...";
	}
	
}
