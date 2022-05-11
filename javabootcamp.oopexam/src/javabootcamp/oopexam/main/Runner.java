package javabootcamp.oopexam.main;

import java.time.LocalDate;

import javabootcamp.oopexam.electricToy.ElectricToy;
import javabootcamp.oopexam.kid.Kid;
import javabootcamp.oopexam.toy.Toy;
import javabootcamp.oopexam.doll.Doll;

/**
*@author Liran Hadad
*/
public class Runner {

	public static void main(String[] args) {
		
		LocalDate date1 = LocalDate.parse("2021-12-27");
		LocalDate date2 = LocalDate.parse("2020-03-27");
		
		Kid kid1 = new Kid("benny",LocalDate.parse("2020-11-27"));
		Kid kid2 = new Kid("benny",LocalDate.parse("2018-11-27"));
		
		Toy[] toys = new Toy[4];
		
		toys[0] = new ElectricToy("Robo1", date2, 'A', kid1, 4);
		toys[1] = new ElectricToy("Robo2", date2, 'B', kid2, 4);
		toys[2] = new Doll("doll1", date1, 'A', kid1, "HARD");
		toys[3] = new Doll("doll2", date1, 'B', kid2, "HARD");
		
		for (Toy toy : toys) {
			toy.play();
		}

	}

}
