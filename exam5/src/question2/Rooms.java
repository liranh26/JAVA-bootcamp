package question2;

public class Rooms {
	
	private float width;
	private float length;
	private boolean hasAC;
	
	public Rooms(float width, float length, boolean hasAC) {
		this.width = width;
		this.length = length;
		this.hasAC = hasAC;
	}

	public float getWidth() {
		return width;
	}

	public float getLength() {
		return length;
	}

	public boolean isHasAC() {
		return hasAC;
	}

	@Override
	public String toString() {
		return "Room : width=" + width + ", length=" + length + ", hasAC=" + hasAC + ".\n";
	}

	
}
