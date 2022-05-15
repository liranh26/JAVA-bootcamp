package command;

public class Runner {

	public static void main(String[] args) {
		
		HeaterApp app = new HeaterApp();
		app.turnOn(30);
		app.turnOff();
		app.turnOn(123);
		app.turnOn(23);
		app.turnOff();
		app.turnOff();
		app.turnOn(222);
		app.turnOff();
		app.turnOn(13);
		System.out.println("----- HISTORY -----");
		app.showHistory();

	}

}
