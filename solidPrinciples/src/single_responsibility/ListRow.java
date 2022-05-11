package single_responsibility;

import java.util.ArrayList;
import java.util.List;

public class ListRow {
	
    public List<String> firstRow(int start, int end, List list) {
 
    	List<String> row = new ArrayList<String>();
    	for (int i = start; i <= end; i++) {
    		row.add((String) list.get(i));
		}
        return row;
    }
	
}
