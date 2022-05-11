package bootcamp.oop.umlLesson;
/**
*@author Liran Hadad
*/
public class FrequentFlyer {
	protected final int FF_NUM;
	protected String firstName;
	protected String lastName;
	protected static int idCounter=0;
	protected int milesCredit;
	
	public FrequentFlyer(String firstName, String lastName) {
		FF_NUM = idCounter++;
		setFirstName(firstName);
		setLastName(lastName);
	}
	
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
	public int getID() {
		return FF_NUM;
	}
}

