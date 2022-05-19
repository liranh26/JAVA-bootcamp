package question2;

import java.util.ArrayList;

public class ObjectFromJSON {

	private Address address;
	private ArrayList<Rooms> rooms;
	private boolean hasYard;
	private boolean hasBasement;
	private double area;

	public ObjectFromJSON(Address address, ArrayList<Rooms> rooms, boolean hasYard, boolean hasBasement, double area) {
		this.address = address;
		this.rooms = rooms;
		this.hasYard = hasYard;
		this.hasBasement = hasBasement;
		this.area = area;
	}

	public Address getAddress() {
		return address;
	}

	public ArrayList<Rooms> getRooms() {
		return rooms;
	}

	public boolean isHasYard() {
		return hasYard;
	}

	public boolean isHasBasement() {
		return hasBasement;
	}

	public double getArea() {
		return area;
	}

	@Override
	public String toString() {
		return "ObjectFromJSON : " + address + ", rooms = " + rooms + ",\nhadYard=" + hasYard + ", hasBasement="
				+ hasBasement + ", area=" + area + "]\n";
	}


}
