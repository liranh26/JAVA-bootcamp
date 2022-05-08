package courseOrganizer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Student {
	protected String name;
	protected int studentId;
	private static int idCounter = 0;
	protected Map<Integer, Course> studentCurriculum;
	protected float avergeScore;
	protected float standardDeviation;
	private int numOfCourses;

	public Student(String name) {
		studentCurriculum = new HashMap<>();
		numOfCourses = 0;
		this.name = name;
		studentId = idCounter++;
	}

	protected void addCourse(Course course) {
		if (course != null)
			studentCurriculum.putIfAbsent(course.courseNumber, course);
	}

	protected float getGrade() {

		Collection<Course> courses = studentCurriculum.values();
		for (Course course : courses) {
			avergeScore += course.grade;
			numOfCourses++;
		}

		return avergeScore / numOfCourses;

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", studentId=" + studentId + ", studentCurriculum=" + studentCurriculum
				+ ", avergeScore=" + avergeScore + ", standardDeviation=" + standardDeviation + ", numOfCourses="
				+ numOfCourses + "]" + "\n";
	}

}
