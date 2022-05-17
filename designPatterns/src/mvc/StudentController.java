package mvc;

public class StudentController {

	private StudentModel studentModel;
	private StudentView studentView;
	private final int NUM_GRADES = 3;

	StudentController(){
		studentModel = new StudentModel();
		studentView = new StudentView();
	}
	
	public void runApp() {
		
		studentModel.setFirstName(studentView.getFirstName());
		studentModel.setLastName(studentView.getLastName());
		
		int[] grades = new int[NUM_GRADES];
		for (int i = 0; i < grades.length; i++) {
			grades[i] = studentView.getgrade();
		}
		
		boolean isExecellenet = studentModel.calcGrades(grades);
		String message = isExecellenet? "execellent" : "great";
		System.out.println(studentModel.getFirstName() + " " 
							+ studentModel.lastName 
								+ " is a " + message + " student.");
	}
	
	
}
