package question2;

public class Address {
	private String street;
	private int number;
	private String state;
	private String city;
	
	public Address(String street, int number, String state, String city) {
		this.street = street;
		this.number = number;
		this.state = state;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public int getNumber() {
		return number;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Address : street=" + street + ", number=" + number + ", state=" + state + ", city=" + city + ".\n";
	}
	
}
