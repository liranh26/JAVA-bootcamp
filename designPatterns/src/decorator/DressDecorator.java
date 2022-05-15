package decorator;

public class DressDecorator implements Dress {

	private Dress wrapee;
	
	public DressDecorator(Dress dress) {
		this.wrapee = dress;
	}
	
	@Override
	public void create() {
		wrapee.create();
	}
	
	
}
