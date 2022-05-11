package lights;

public class Light {

	// fields
	private int numOfBulbs;
	private boolean isOn;

	// constructors
	public Light() {
		this(3, true);
	}

	public Light(int inputNumOfBulbs, boolean statusOfBulbs) {
		setNumBulbs(inputNumOfBulbs);
		setLightStatus(statusOfBulbs);
	}

	// methods
	public void turnOn() {
		isOn = true;
		System.out.println("turned On!");
	}

	public void turnOff() {
		isOn = false;
		System.out.println("turned Off!");
	}

	public void printBulbsStatus() {
		String status = isOn ? "On" : "Off";
		System.out.println(status + " & the bulbs numberis is: " + numOfBulbs);
	}

	public void setNumBulbs(int numOfBulbs) {
		if (numOfBulbs > 0 && numOfBulbs < 50) {
			this.numOfBulbs = numOfBulbs;
		}
	}

	public void setLightStatus(boolean isOn) {
		this.isOn = isOn;
	}

	public boolean getLightStatus() {
		return isOn;
	}

	public int getNumBulbs() {
		return numOfBulbs;
	}

	public void toggle(Light light) {
		light.isOn = !light.isOn;
	}
	
	public void toggle() {
		toggle(this);
	}
	

}
