package exam4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TentManager {

	protected ArrayList<Tent> tents;

	TentManager(List<Tent> tents) {
		this.tents = new ArrayList<Tent>(tents);
	}

	public List<Tent> tentsByArea(List<Tent> tents) {
		return tents.stream()
				.sorted((t1, t2) -> (int) (t2.area - t1.area))
				.collect(Collectors.toList());
	}

	public List<Tent> sortByPeopleNum(List<Tent> tents, int numPeople) {

		return tents.stream().filter(t -> numPeople <= t.numPeople)
				.sorted((t1, t2) -> t2.numPeople - t1.numPeople)
				.collect(Collectors.toList());
	}

	public boolean isHighest(List<Tent> tents, Tent tent) {
		return tent.height == tents.stream()
				.sorted((t1, t2) -> (int) (t2.height - t1.height))
				.collect(Collectors.toList()).get(0).height;
	}

	public Map<Double, List<Tent>> createMapTentsByHieght(List<Tent> tents) {

		ArrayList<Tent> tmpList = new ArrayList<>(tents);
		Map<Double, List<Tent>> tentMap = new HashMap<>();
		
		while (!tmpList.isEmpty()) {
			Tent currTent = tmpList.get(0);
			
			List<Tent> allHieght = tmpList.stream()
					.filter(t -> currTent.height == t.height)
					.collect(Collectors.toList());
			
			tentMap.put(currTent.height, allHieght);
			
			tmpList.removeAll(allHieght);
		}

		return tentMap;
	}
	

	public List<Tent> sortTentsByHieght(Map<Double, List<Tent>> map, double minHieght, double maxHieght) {
		
		List<Tent> sorted = new ArrayList<>();
		
		map.values().forEach(t -> {
			if(t.get(0).height >= minHieght && t.get(0).height <= maxHieght )
				sorted.addAll(t);
		});

		return sorted;
	}

}
