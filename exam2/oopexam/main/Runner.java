package javabootcamp.oopexam.main;

import java.time.LocalDate;

import javabootcamp.oopexam.electricToy.ElectricToy;
import javabootcamp.oopexam.kid.Kid;
import javabootcamp.oopexam.toy.Toy;

/**
*@author Liran Hadad
*/
public class Runner {

	public static void main(String[] args) {
		LocalDate date = LocalDate.parse("2021-12-27");
		LocalDate today = LocalDate.now();
		Kid kid1 = new Kid("benny",LocalDate.parse("2020-11-27"));
		Toy robo1 = new ElectricToy("Robo1", date, 'B', kid1, 4);
		Toy robo2 = new ElectricToy("Robo2", date, 'A', kid1, 4);
		Toy tedy1 = new Doll("doll1", date, 'A', kid1, DollType );
	
		robo1.play();
	}

}
