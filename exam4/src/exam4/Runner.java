package exam4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Runner {

	public static void main(String[] args) {

		List<Tent> tents = Arrays.asList(
				new Tent(4, 4, 5, 10),
				new Tent(2, 2, 3, 5),
				new Tent(10, 40, 40, 100),
				new Tent(15, 20, 30, 90),
				new Tent(20, 50, 50, 120.3),
				new Tent(15, 40, 40, 120.5),
				new Tent(5, 10, 10, 60),
				new Tent(5, 15, 15, 20),
				new Tent(4, 15, 20, 50),
				new Tent(10, 50, 50, 80));
		
		TentManager app = new TentManager(tents);
		
		System.out.println("-------- Original Tents List --------");
		System.out.println(tents);

		System.out.println("-------- Sorted Tents List --------");
		System.out.println(app.tentsByArea(tents));
		
		System.out.println("-------- Sorted by number od People --------");
		System.out.println(app.sortByPeopleNum(tents, 10));
		
		System.out.println("-------- Check if a Tent is the highest --------");
		System.out.println(tents.get(5) + "is one of the hishest ? " + app.isHighest(tents, tents.get(5)));
		
		System.out.println("-------- Create map --------");
		Map<Double, List<Tent>> mapedTents = app.createMapTentsByHieght(tents);
		System.out.println(mapedTents);
		
		System.out.println("-------- use map to sort by hieght --------");
		System.out.println(app.sortTentsByHieght(mapedTents, 30, 100));
	}


}
