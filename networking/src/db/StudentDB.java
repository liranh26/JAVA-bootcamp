package db;

import java.util.HashMap;
import java.util.Map;

public class StudentDB {

	private final static Map<Long, Student> students = new HashMap<>() {
		{
			put(1000l, new Student("Alex Batura", 20));
			put(1001l, new Student("Amir Shachar", 21));
			put(1002l, new Student("Anna Aba", 22));
			put(1003l, new Student("Ayala Makalchi", 23));
			put(1004l, new Student("Dana Grossman", 24));
		}
	};

	public static Student getStudentById(long id) {
		return students.get(id);
	}
}
