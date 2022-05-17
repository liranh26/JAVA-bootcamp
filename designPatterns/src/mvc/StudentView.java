package mvc;

public class StudentView {

	public String getFirstName() {
		System.out.println("Enter your first name: ");
		return StudentInput.getStringFromUser();
	}
	
	public String getLastName() {
		System.out.println("Enter your last name: ");
		return StudentInput.getStringFromUser();
	}
	
	public int getgrade() {
		System.out.println("Enter your exam grade: ");
		return StudentInput.getIntFromUser();
	}

	public void printMessage(boolean isExcellent) {
		if(isExcellent)
			System.out.println("You are a excellent student!");
		else
			System.out.println("You are a great student!");

	}
	
}
