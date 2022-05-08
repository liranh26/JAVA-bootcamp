package sortingGamers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Iterator;

public class ScoreBoard {

	protected ArrayList<Gamer> gamers;
	protected ArrayList<Gamer> top3;
	private final int NUM_TOP_PLAYERS = 3;

	public ScoreBoard() {
		gamers = new ArrayList<>();
		top3 = new ArrayList<>();
		intializeGamers();
		intializeTop3();
	}

	private void intializeGamers() {
		gamers.add(new Gamer("Liran", 12049, "Israel", 120));
		gamers.add(new Gamer("Ola", 2352, "Israel", 192));
		gamers.add(new Gamer("Tama", 23564, "Israel", 1200));
		gamers.add(new Gamer("Asaf", 12204, "Israel", 205));
		gamers.add(new Gamer("Alon", 12104, "Israel", 504));
		gamers.add(new Gamer("Shiri", 1204, "Israel", 900));
	}

	private void intializeTop3() {
		for (int i = 0; i < 3; i++) {
			top3.add(null);
		}
	}

	protected void run() {
		sortByScore();
		System.out.println(gamers);
		
		setTop3();
		System.out.println(top3);
		
		sortByName();
		System.out.println("------- sorted by name -------");
		System.out.println(gamers);
		
		sortByHours();
		System.out.println("------- sorted by hours -------");
		System.out.println(gamers);
		
		for (Gamer gamer : gamers) {
			if(gamer.name.equals("Asaf"))
				gamer.score = 100;
		}
		/** change score using using iterator **/
//		Iterator<Gamer> iterator = gamers.iterator();
//		while(iterator.hasNext()) {
//			Gamer gamer = iterator.next();
//			if(gamer.name.equals("Asaf"))
//				gamer.score = 150;
//		}
			
		updateTop3();
		System.out.println(top3);
	}

	protected void sortByScore() {
		Collections.sort(gamers);
	}

	protected void setTop3() {
		for (int i = 0; i < NUM_TOP_PLAYERS && gamers.get(i) != null; i++) {
			top3.set(i, gamers.get(i));
		}
	}

	protected void sortByName() {
		Collections.sort(gamers, nameComparator);
	}

	/* Comparator for sorting the list by Gamer Name */
	/* Anonymous class - Sort Gamer by Name */
	Comparator<Gamer> nameComparator = new Comparator<Gamer>() {
		@Override
		public int compare(Gamer gamer1, Gamer gamer2) {
			// descending order
			return gamer1.name.compareTo(gamer2.name);
		}
	};

	private void sortByHours() {
		Collections.sort(gamers, hoursComperator);
	}
	
	Comparator<Gamer> hoursComperator = new Comparator<Gamer>() {
		@Override
		public int compare(Gamer gamer1, Gamer gamer2) {
			return (int) (gamer2.hours - gamer1.hours);
		}
	};
	
	@Override
	public String toString() {
		return "ScoreBoard [top3=" + top3 + "]";
	}
	
	protected void updateTop3() {
		sortByScore();
		setTop3();
	}

}
