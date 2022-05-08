package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericClassExample<T> implements GenericExample<T>{
	
	private T t;
	
	public GenericClassExample(T t){
		this.t =t;
	}

	@Override
	public List<T> newReversedCopy(List<T> inputList) {
		
		List<T> reveresedList = new ArrayList<T>(inputList);
		
		Collections.reverse(reveresedList);
		
		return reveresedList;
	}
	
	
}
