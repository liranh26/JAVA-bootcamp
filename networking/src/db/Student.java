package db;

import java.io.Serializable;

// we will use this class as a json object -> then we no need to do here to implement Serializable!
//we will use it to send java object
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

	private static long counterId = 1000l;
	
	private final long ID;
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.ID = counterId++;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
