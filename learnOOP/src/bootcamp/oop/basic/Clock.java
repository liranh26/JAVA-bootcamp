package bootcamp.oop.basic;

public class Clock {
	//fields
	int timeInMin;   
	
	//methods
	public void printTime() {
		int hours = timeInMin/60;
		int minutes = timeInMin%60;
		System.out.printf("%02d:%02d", hours, minutes);
	}
	
	//constructors
	public Clock(int time) {
		timeInMin = time;
	}
}
