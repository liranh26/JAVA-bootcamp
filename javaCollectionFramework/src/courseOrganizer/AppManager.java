package courseOrganizer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AppManager {
	
	protected Map<Integer, Student> students;
	
	public AppManager() {
		students = new HashMap<>();
		initializeStudArray();
		
	}
	
	protected void addStudent(Student student) {
		if(student == null)
			return;
		students.put(student.studentId, student);
		student.avergeScore = student.getGrade();
		setStandDev(student);
	}
	
	protected void initializeStudArray() {

		Student[] demoStudents = new Student[3];
		
		demoStudents[0] = new Student("Liran");
		demoStudents[0].addCourse(new Course("Math", "Ben Gurion", 90f));
		demoStudents[0].addCourse(new Course("Science", "Ben Gurion", 85f));
		demoStudents[0].addCourse(new Course("Solid", "Ben Gurion", 95f));
		
		demoStudents[1] = new Student("Sapir");
		demoStudents[1].addCourse(new Course("Litreture", "Ben Gurion", 100f));
		demoStudents[1].addCourse(new Course("Science", "Ben Gurion", 100f));
		demoStudents[1].addCourse(new Course("Managment", "Ben Gurion", 97f));
		
		demoStudents[2] = new Student("Alon");
		demoStudents[2].addCourse(new Course("Math", "Ben Gurion", 80f));
		demoStudents[2].addCourse(new Course("Managment", "Ben Gurion", 75f));
		demoStudents[2].addCourse(new Course("Science", "Ben Gurion", 94f));

		for (Student student : demoStudents) {
			addStudent(student);
		}
		
	}
	
	private void setStandDev(Student studentToSet) {
		float sumStudentsScore=0;
		
		Collection<Student> studentCollection = students.values();
		for (Student student : studentCollection) {
			sumStudentsScore += student.avergeScore;
		}
		sumStudentsScore/=students.size();
		
		float numerator = 0;
		for (Student student : studentCollection) {
			numerator += Math.pow(student.avergeScore - sumStudentsScore, 2);
		}
		
		float denominator = (students.size()-1);
		float std = (float) Math.sqrt(numerator / denominator );
		studentToSet.standardDeviation = std;
	}
	
	
	protected void printStudentGrade(int id) {
		float score = students.get(id).getGrade();
		System.out.println("Your score" + score);
	}

	@Override
	public String toString() {
		return "AppManager [students=" + students + "]";
	}
	
	
	
}
