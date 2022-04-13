package bootcamp.designExe;

public class Author {
	private String name;
	private char gender;
	
	public Author(String name, char gender) {
		setName(name);
		setGender(gender);
	}
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	private void setGender(char gender) {
		this.gender = gender;
	}
	
	
}
