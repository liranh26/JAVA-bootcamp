package singleton;

import java.util.Arrays;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
//		GameManager app = new GameManager();
//		
//		app.play();

		List<Player> players = Arrays.asList(
				new Player("Liran"),
				new Player("Tama"),
				new Player("Asaf"),
				new Player("Alon"));
		
		GameManagerVer2 app = new GameManagerVer2(players);
		
		app.play();
		
	}

}
