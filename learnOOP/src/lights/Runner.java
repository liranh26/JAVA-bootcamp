package lights;

public class Runner {

	public static void main(String[] args) {
		Light light1 = new Light();
//		Light light2 = new Light(5, false);
		
//		//print status of lights
//		System.out.print("light1 status is: ");
//		light1.printBulbsStatus();
//		System.out.print("light2 status is: ");
//		light2.printBulbsStatus();
//		
//		//changing values for lights
//		light1.turnOff();
//		light2.setNumBulbs(10);
//		
//		//print status of lights
//		System.out.print("light1 status is: ");
//		light1.printBulbsStatus();
//		System.out.print("light2 status is: ");
//		light2.printBulbsStatus();
//		
//		//turn them both back On
//		light1.turnOff();
//		light2.turnOff();
//
//		//make same num of bulbs for the lights
//		light1.printBulbsStatus();
		
		light1.printBulbsStatus();
		light1.toggle();
		light1.printBulbsStatus();
	}

}
