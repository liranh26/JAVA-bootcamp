package single_responsibility;

import java.util.ArrayList;

public class SolidBoard {
	public ArrayList<String> spots;
	
	int size;
	
	public SolidBoard(int size) {
		this.size = size;
		this.spots = new ArrayList<String>();
		for (int i = 0; i < size*size; i++) {
			this.spots.add(String.valueOf(i));
		}
	}
}
