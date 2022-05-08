package generic;

import java.util.Arrays;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		GenericClassExample<Integer> generic = new GenericClassExample<>(8);
		List<Integer> data = Arrays.asList(100, 8, 50, 90);
		List<Integer> revData = generic.newReversedCopy(data);
		
		System.out.println(revData);
		
	}
	
	

}
