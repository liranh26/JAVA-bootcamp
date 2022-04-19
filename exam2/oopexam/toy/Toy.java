package javabootcamp.oopexam.toy;

import java.time.LocalDate;

import javabootcamp.oopexam.kid.Kid;

/**
*@author Liran Hadad
*/
public abstract class Toy {
	private static int serialCounter=0;
	private final int serialNum;
	protected String name;
	private LocalDate purchaseDay;
	protected char groupClass;
	protected int toyAge;
	protected int kidAge;
	protected boolean isBroken=false;
	
	
	public Toy(String name, LocalDate purchaseDay, char groupClass, Kid kid) {
		this.serialNum = serialCounter++;
		this.purchaseDay = purchaseDay;
		this.groupClass = groupClass;
		setToyAge();
		kidAge = kid.getAge();
	}
	
	
	private void setToyAge() {
		LocalDate today = LocalDate.now();
		toyAge = today.minusYears(purchaseDay.getYear()).getYear();

	}
	
	
	protected boolean isPlayable() {
		
		switch(this.groupClass) {
		case 'A': 
			return checkValidAge(0, 1);
		case 'B':
			return checkValidAge(2, 4);
		case 'C':
			return checkValidAge(5, 10);
		}
		
		return false;
	}
	
	private boolean isToyNotBroke() {
		if(toyAge >= 1)
			return false;
		
		return true;
	}
	
	private boolean checkValidAge(int minAllowed, int maxAllowed) {
		if(kidAge >= minAllowed && kidAge <= maxAllowed && isToyNotBroke())
			return true;
		return false;
	}
	
	
	public abstract void play();


	public int getSerialNumber() {
		return serialNum;
	}


	@Override
	public String toString() {
		return "Toy [serialNum=" + serialNum + ", name=" + name + ", purchaseDay=" + purchaseDay + ", groupClass="
				+ groupClass + ", toyAge=" + toyAge + ", kidAge=" + kidAge + ", isBroken=" + isBroken + "]";
	}
	
	
}






//enum GroupClass{
//	A,B,C;
//}
