package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class QueryExercise {

	public static void run() {
		List<Student> students = new ArrayList<>();

		try {
			File inputFile = new File("myFiles/myStudents.xml");
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(inputFile);

			System.out.println("Root element: " + document.getRootElement().getName());
			Element studentsElement = document.getRootElement();

			List<Element> studentsList = studentsElement.getChildren();
			for (Element student : studentsList) {
				System.out.println("Current student: " + student.getName());
				students.add(parseStudent(student));

				student.getChild("note").getChildren();
			}

			System.out.println(students);

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Student parseStudent(Element student) {

		Attribute attribute = student.getAttribute("id");
		long rollNumber = Long.parseLong(attribute.getValue());
		String gender = student.getChild("gender").getText();
		String firstName = student.getChild("firstName").getText();
		String lastName = student.getChild("lastName").getText();

		student.getChild("note");
		List<Element> notes = student.getChildren();
		
		List<String> studentNotes = new ArrayList<>();

		for (Element note : notes) {
			studentNotes.add(parseNote(note));
		}

		return new Student(rollNumber, gender, firstName, lastName, studentNotes);
	}

	private static String parseNote(Element note) {

		String parsedNote = "From " + note.getChild("from").getText() + ", To " + note.getChild("to").getText()
				+ " Message: " + note.getChild("body").getText();
		return parsedNote;
	}

}
