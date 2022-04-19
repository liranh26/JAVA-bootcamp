package javabootcamp.oopexam.kid;

import java.time.LocalDate;

/**
*@author Liran Hadad
*/
public class Kid {
	protected String name;
	protected LocalDate birthDate;
	protected int age;
	
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
		return age;
	}
	public void setAge() {
		LocalDate today = LocalDate.now();
		age = today.minusYears(birthDate.getYear()).getYear();
	}
	
}
