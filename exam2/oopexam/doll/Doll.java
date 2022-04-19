package javabootcamp.oopexam.doll;

import java.time.LocalDate;

import javabootcamp.oopexam.kid.Kid;
import javabootcamp.oopexam.toy.Toy;

/**
*@author Liran Hadad
*/
public class Doll extends Toy{
	
	protected DollType dollType;
	private static int dirtness=0;

	public Doll(String name, LocalDate purchaseDay, char groupClass, Kid kid, DollType dollType) {
		super(name, purchaseDay, groupClass, kid);
		this.dollType = dollType;
	}

	@Override
	public void play() {
		if(isPlayable()) {
			setDirtiness();
			System.out.println(this);
		}
		else
			System.out.println("This toy is not playable now!");
	}
	
	private void setDirtiness() {
		if(dirtness < 10)
			dirtness++;
	}

	@Override
	public String toString() {
		return "Doll [dollType=" + dollType + ", name=" + name + ", groupClass=" + groupClass + ", toyAge=" + toyAge
				+ ", kidAge=" + kidAge + ", isBroken=" + isBroken + "]";
	}


	
	
	
	
}


enum DollType{
	SOFT, HARD;
}