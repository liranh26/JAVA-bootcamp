package javabootcamp.oopexam.kid;

import java.time.LocalDate;
import java.time.Period;

/**
*@author Liran Hadad
*/
public class Kid {
	protected String name;
	protected LocalDate birthDate;
	protected int yearAge;
	
	public Kid(String name, LocalDate birthDate) {
		setName(name);
		setBirthDate(birthDate);
		setAge();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public int getAge() {
		return yearAge;
	}
	public void setAge() {
		Period period = Period.between(birthDate, LocalDate.now());
		yearAge = period.getYears();
	}
	
}
