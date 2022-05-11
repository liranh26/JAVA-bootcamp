package javabootcamp.oopexam.electricToy;

import java.time.LocalDate;

import javabootcamp.oopexam.kid.Kid;
import javabootcamp.oopexam.toy.Toy;

/**
*@author Liran Hadad
*/
public class ElectricToy extends Toy {
	
//	protected DollType dollType;
	private static int sound=3;
	private final int batteriesNum;
	
	public ElectricToy(String name, LocalDate purchaseDay, char groupClass, Kid kid, int batteriesNum) {
		super(name, purchaseDay, groupClass, kid);
		this.batteriesNum=batteriesNum;
	}

	@Override
	public void play() {
		
		if(isPlayable()) {
			setSound();
			System.out.println(this);
		}
		else
			System.out.println("This toy is not playable now!");
	}
	
	private void setSound() {
		if(sound > 0)
			sound--;
	}

	@Override
	public String toString() {
		return "ElectricToy [batteriesNum=" + batteriesNum + ", name=" + name + ", groupClass=" + groupClass
				+ ", toyAge=" + toyAge + ", kidAge=" + kidAge + ", isBroken=" + isBroken + "]";
	}
	
	
	

}
