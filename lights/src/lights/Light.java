package lights;

public class Light {
	
	//fields
	int numOfBulbs;
	static boolean isOn;
	
	//constructors
	
	public Light(int inputNumOfBulbs, boolean status) {
		numOfBulbs = inputNumOfBulbs;
		isOn = status;
	}
	
	public Light() {
		numOfBulbs = 3;
		isOn = true;
	}
	
	//methods
	
	public static void turnOn() {
		isOn = true;
		System.out.println("On");
	}
	
	public static void turnOff() {
		isOn = false;
		System.out.println("Off");
	}
	
}
