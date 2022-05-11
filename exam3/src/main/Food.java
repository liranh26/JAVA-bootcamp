package main;

import java.io.Serializable;

import exceptions.NonCapatilizedException;

public class Food implements Serializable {
	
	private static final long serialVersionUID = 768171738267426517L;
	public String name;
	protected Macronutrients macronutrients;
	protected Taste taste;
	
	
	public Food() {
		this("default", Macronutrients.Protein, Taste.Sweet);
	}
	
	public Food(String name, Macronutrients macronutrients, Taste taste) {
		try {
			setName(name);
		} catch (NonCapatilizedException e) {
			System.out.println(e + ", Enter a name with a capital letter!");
		}
		this.macronutrients = macronutrients;
		this.taste = taste;
	}
	
	public boolean isDesert() {
		if(taste == Taste.Sweet && macronutrients == Macronutrients.CarboHydrate)
			return true;
		return false;
	}
	

	public void setName(String name) throws NonCapatilizedException {
		if(!Character.isUpperCase(name.charAt(0)))
			//An checked exception! -> need try catch at constructor
			throw new NonCapatilizedException();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Food [name=" + name + ", macronutrients=" + macronutrients + ", taste=" + taste + "]";
	}
	
}
