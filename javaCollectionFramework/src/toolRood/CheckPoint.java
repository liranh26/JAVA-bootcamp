package toolRood;
/**
*@author Liran Hadad
*/
public class CheckPoint {
	
	protected String name;
	protected String address;
	protected int position;
	
	public CheckPoint(String name, String address, int position) {
		this.name = name;
		this.address = address;
		this.position = position;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getAddress() {
		return address;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	protected int getPosition() {
		return position;
	}

	protected void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "CheckPoint [name=" + name + ", address=" + address + ", position=" + position + "]";
	}
	
	
	
	
}
