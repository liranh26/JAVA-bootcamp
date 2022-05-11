package courseOrganizer;

public class Course {
	protected static int courseIndex = 0;
	protected String name;
	protected final int courseNumber;
	protected String school;
	protected float grade;
	
	
	public Course(String name, String school, float grade) {
		this.name = name;
		this.school = school;
		this.grade = grade;
		courseNumber = courseIndex++;
	}


	@Override
	public String toString() {
		return "Course [name=" + name + ", courseNumber=" + courseNumber + ", school=" + school + ", grade=" + grade
				+ "]" + "\n";
	}
	
	
	
}
