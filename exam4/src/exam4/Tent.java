package exam4;

public class Tent {
	protected int numPeople;
	protected double width, length, height;
	double area;

	public Tent(int numPeople, int width, int length, int height) {
		this.numPeople = numPeople;
		this.width = width;
		this.length = length;
		this.height = height;
		setArea();
	}
	
	
	
	private void setArea() {
		area = width*length;
	}
	
	public double getTentArea() {
		return area;
	}

	@Override
	public String toString() {
		return "Tent [numPeople=" + numPeople + ", width=" + width + ", length=" + length + ", height=" + height + ", area=" + area + "]\n";
	}

}
