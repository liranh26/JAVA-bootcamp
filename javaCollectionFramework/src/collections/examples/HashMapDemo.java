package collections.examples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void run() {

		// -------------------------------------------------------------------//
		// Creating a HashMap and Adding key-value pairs to it
		// -------------------------------------------------------------------//

		// Creating a HashMap
        Map<String, Integer> numberMapping = new HashMap<>();

        // Adding key-value pairs to a HashMap
        numberMapping.put("One", 1);
        numberMapping.put("Two", 2);
        numberMapping.put("Three", 3);

        // Add a new key-value pair only if the key does not exist in the HashMap, or is mapped to `null`
        numberMapping.putIfAbsent("Four", 4);

        System.out.println(numberMapping);

		// -------------------------------------------------------------------//
		// Accessing keys and modifying their associated value in a HashMap
		// -------------------------------------------------------------------//

        Map<String, String> userCityMapping = new HashMap<>();

        // Check if a HashMap is empty
        System.out.println("is userCityMapping empty? : " + userCityMapping.isEmpty());

        userCityMapping.put("John", "New York");
        userCityMapping.put("Michael", "Bengaluru");
        userCityMapping.put("Steve", "London");

        System.out.println("userCityMapping HashMap : " + userCityMapping);

        // Find the size of a HashMap
        System.out.println("We have the city information of " + userCityMapping.size() + " users");

        String userName = "Steve";
        // Check if a key exists in the HashMap
        if(userCityMapping.containsKey(userName)) {
            // Get the value assigned to a given key in the HashMap
            String city = userCityMapping.get(userName);
            System.out.println(userName + " lives in " + city);
        } else {
            System.out.println("City details not found for user " + userName);
        }

        // Check if a value exists in a HashMap
        if(userCityMapping.containsValue("New York")) {
            System.out.println("There is a user in the userCityMapping who lives in New York");
        } else {
            System.out.println("There is no user in the userCityMapping who lives in New York");
        }


        // Modify the value assigned to an existing key
        userCityMapping.put(userName, "California");
        System.out.println(userName + " moved to a new city " + userCityMapping.get(userName) + ", New userCityMapping : " + userCityMapping);

        // The get() method returns `null` if the specified key was not found in the HashMap
        System.out.println("Lisa's city : " + userCityMapping.get("Lisa"));

		// -------------------------------------------------------------------//
		// Removing keys from a HashMap
		// -------------------------------------------------------------------//

        Map<String, String> husbandWifeMapping = new HashMap<>();
        husbandWifeMapping.put("Jack", "Marie");
        husbandWifeMapping.put("Chris", "Lisa");
        husbandWifeMapping.put("Steve", "Jennifer");

        System.out.println("Husband-Wife Mapping : " + husbandWifeMapping);

        // Remove a key from the HashMap
        // Ex - Unfortunately, Chris got divorced. Let's remove him from the mapping
        String husband = "Chris";
        String wife = husbandWifeMapping.remove(husband);

        System.out.println("Couple (" + husband + " => " + wife + ") got divorced");
        System.out.println("New Mapping : " + husbandWifeMapping);

        // Remove a key from the HashMap only if it is mapped to the given value
        // Ex - Divorce "Jack" only if He is married to "Linda"
        boolean isRemoved = husbandWifeMapping.remove("Jack", "Linda");
        System.out.println("Did Jack get removed from the mapping? : " + isRemoved);

        // remove() returns null if the mapping was not found for the supplied key
        wife = husbandWifeMapping.remove("David");
        if(wife == null) {
            System.out.println("Looks like David is not married to anyone");
        } else {
            System.out.println("Removed David and his wife from the mapping");
        }

		// -------------------------------------------------------------------//
		// Obtaining the entrySet, keySet, and values from a HashMap
		// -------------------------------------------------------------------//
        Map<String, String> countryISOCodeMapping = new HashMap<>();

        countryISOCodeMapping.put("India", "IN");
        countryISOCodeMapping.put("United States of America", "US");
        countryISOCodeMapping.put("Russia", "RU");
        countryISOCodeMapping.put("Japan", "JP");
        countryISOCodeMapping.put("China", "CN");

        // HashMap's entry set
        Set<Map.Entry<String, String>> countryISOCodeEntries = countryISOCodeMapping.entrySet();
        System.out.println("countryISOCode entries : " + countryISOCodeEntries);

        // HashMap's key set
        Set<String> countries = countryISOCodeMapping.keySet();
        System.out.println("countries : " + countries);

        // HashMap's values
        Collection<String> isoCodes = countryISOCodeMapping.values();
        System.out.println("isoCodes : " + isoCodes);

		// -------------------------------------------------------------------//
		// Iterating over a HashMap
		// -------------------------------------------------------------------//
        Map<String, Double> employeeSalary = new HashMap<>();
        employeeSalary.put("David", 76000.00);
        employeeSalary.put("John", 120000.00);
        employeeSalary.put("Mark", 95000.00);
        employeeSalary.put("Steven", 134000.00);

        System.out.println("=== Iterating over a HashMap using Java 8 forEach and lambda ===");
        employeeSalary.forEach((employee, salary) -> {
            System.out.println(employee + " => " + salary);
        });

        System.out.println("\n=== Iterating over the HashMap's entrySet using iterator() ===");
        Set<Map.Entry<String, Double>> employeeSalaryEntries = employeeSalary.entrySet();
        Iterator<Map.Entry<String, Double>> employeeSalaryIterator = employeeSalaryEntries.iterator();
        while (employeeSalaryIterator.hasNext()) {
            Map.Entry<String, Double> entry = employeeSalaryIterator.next();
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("\n=== Iterating over the HashMap's entrySet using Java 8 forEach and lambda ===");
        employeeSalary.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        });

        System.out.println("\n=== Iterating over the HashMap's entrySet using simple for-each loop ===");
        for(Map.Entry<String, Double> entry: employeeSalary.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("\n=== Iterating over the HashMap's keySet ===");
        employeeSalary.keySet().forEach(employee -> {
            System.out.println(employee + " => " + employeeSalary.get(employee));
        });

		// -------------------------------------------------------------------//
		// HashMap with User defined objects
		// -------------------------------------------------------------------//
        Map<Integer, Employee> employeesMap = new HashMap<>();

        int id1 = 1001;
        employeesMap.put(id1, new Employee(id1, "Michael", "Bengaluru"));
        employeesMap.put(1002, new Employee(1002, "David", "New York"));
        employeesMap.put(1003, new Employee(1003, "Jack", "Paris"));

        System.out.println(employeesMap);
	}
}