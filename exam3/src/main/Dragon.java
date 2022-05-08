package main;

import java.io.Serializable;
import java.time.LocalDate;

import exceptions.TooYoungException;

public class Dragon implements Serializable{

	private static final long serialVersionUID = 864239237865003952L;
	protected String name;
	protected LocalDate birthdate;
	protected int flameIntensity;
	
	public Dragon(String name, LocalDate birthdate, int flameIntensity) {
		this.name = name;
		setBirthDate(birthdate);
		this.flameIntensity = flameIntensity;
	}
	
	protected void setBirthDate(LocalDate birthdate) throws TooYoungException {
		if(birthdate.isAfter(LocalDate.of(888, 8, 8)))
			//An unchecked exception! -> no compile error.. my responsibility to catch
			throw new TooYoungException();
		this.birthdate = birthdate;
	}
	
	
	public LocalDate getBirthdate() {
		return birthdate;
	}

	@Override
	public String toString() {
		return "Dragon [name=" + name + ", birthdate=" + birthdate + ", flameIntensity=" + flameIntensity + "]";
	}
	
}
