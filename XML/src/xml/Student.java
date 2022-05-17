package xml;

import java.util.List;

public class Student {
	
	public long id;
	public String gender;
	public String firstName;
	public String lastName;
	public List<String> notes;
	
	public Student(long id, String gender, String firstName, String lastName, List<String> notes) {
		this.id = id;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", notes=" + notes + "]\n";
	}
		
}
