package bootcamp.oop.polymorphism;

import java.time.LocalTime;

//import bootcamp.oop.exercise.HomeAppliance;
import bootcamp.oop.exercise.Television;

public class Runner {

	public static void main(String[] args) {
//		HomeAppliance homeApp1 = new HomeAppliance("TUSHIBA", 2001, 150);
		
//		HomeAppliance homeApp2 = new HomeAppliance("Tushiba", 222);
		
//		homeApp1.display();
//		homeApp2.display();
//		System.out.println(homeApp1);
//		System.out.println(homeApp2);

		
		Television tv1 = new Television("TUSHIBA", 2001, 6.7f, "RF", 150);
		tv1.setModel("G45");
		
		Television tv2 = new Television("Panasonic", 111, 1f, "IR", 200);
		tv2.setModel("3333");
		
		System.out.println(tv1);
		System.out.println(tv2);
		
		int res = tv1.isBigger(tv2);
		String resText = "The Same as";
		if(res==1)
			resText = "Bigger than";
		else if (res == -1)
			resText = "Smaller than";
			
		resText = "TV1 is "+resText+" Tv2";
		System.out.println(resText);
		
		System.out.println("The power consumption: " + tv1.getTotalPowerConsumption(10) +" [Watt]");
		
		System.out.println(tv1.isSmart());
		System.out.println(tv2.isSmart());
		
		System.out.println(tv1.turnOffSec(LocalTime.of(10,43,12)));
		
	}

}
