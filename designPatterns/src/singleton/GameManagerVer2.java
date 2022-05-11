package singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManagerVer2 {
	private final int ADD_POINT = 1;
	private int i;
	ArrayList<Player> players;
	CardPack deck;

	GameManagerVer2(List<Player> players) {
		this.players = new ArrayList<Player>(players);
		deck = CardPack.getInstance();
		i = 1;
	}

	public void play() {
		while (!CardPack.cards.isEmpty()) {
			playRound();
		}
		printWinner();
	}

	private void printPlayers() {
		System.out.println("---------------------");
		players.stream().forEach(p -> System.out.println(p));
		System.out.println("---------------------\n");
	}

	private void playRound() {
		players.stream().forEach(p -> p.drawCard());
		;
		roundWinner().setPoints(ADD_POINT);
		printRoundWinner();
		printPlayers();
	}

	private void printRoundWinner() {
		System.out.println("-----Round %d winner-----".formatted(i++));
		System.out.println(roundWinner());
	}

	private Player roundWinner() {
		return Collections.max(players, (p1, p2) -> p1.getCard() - p2.getCard());
	}

	private void printWinner() {
		System.out.println("----- The Winner is -----");
		System.out.println(Collections.max(players, (p1, p2) -> p1.getPoints() - p2.getPoints()));
	}

}
