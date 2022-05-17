package mvc;

public class StudentModel {

	private final double EXELLENT_GRADE = 90;
	public String firstName;
	public String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean calcGrades(int[] grades) {
		double avarge = 0;
		for (int i = 0; i < grades.length; i++) {
			avarge += grades[i];
		}
		
		return (avarge/grades.length) >= EXELLENT_GRADE;
	}
	
	
}
