package lambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {

		ArrayList<Person> persons = new ArrayList<>();

//		AddPerson addPer = (p) -> persons.add(p);

		persons.add(new Person("liran", "hadad", 32));
		persons.add(new Person("guy", "turgibot", 25));
		persons.add(new Person("amir", "shachar", 24));
		persons.add(new Person("ayala", "badi", 19));
		persons.add(new Person("guy", "turgibot", 20));

		Collections.sort(persons, (p1, p2) -> p1.lastName.compareTo(p2.lastName));
		System.out.println(persons);

		System.out.println("------ 'o' letter not include in the name ------");
		persons.stream().forEach(p -> checkO(p));
		/*Or inside the body*/
		persons.stream().forEach(p -> {
			if (!p.lastName.contains("o") && !p.firstName.contains("o"))
				System.out.println(p);
		});
		
		System.out.println("------ under age 21 ------");
		List<Person> underAge = persons.stream().filter(p -> p.age<21).collect(Collectors.toList());
		System.out.println(underAge);


	}

	static void checkO(Person p) {
		if (!p.lastName.contains("o") && !p.firstName.contains("o"))
			System.out.println(p);

	}

}
