package singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	private final int numOfRounds = 10, addPoint = 1;
	int numPlayers, cardsDraw;
//	CardPack pack;
	ArrayList<Player> players;
	Random rand;
	Scanner sc;

	public GameManager() {
		CardPack.getInstance();
		players = new ArrayList<>();
		numPlayers = Player.randomNumPlayers();
		cardsDraw = 0;
		rand = new Random();
		sc = new Scanner(System.in);
		setPlayers();
	}

	Comparator<Player> roundWinner = (p1, p2) -> p2.getCard() - p1.getCard();
	Comparator<Player> gameWinner = (p1, p2) -> p2.getPoints() - p1.getPoints();

	public void play() {
		for (int i = 0; i < numOfRounds; i++) {
			drawCards();
			getWinner(roundWinner).setPoints(addPoint);
		}

		System.out.println(getWinner(gameWinner));

		sc.close();
	}

	private Player getWinner(Comparator<Player> comp) {
		Collections.sort(players, comp);
		return players.get(0);
	}

	private void setPlayers() {
		System.out.println("Number of player to play " + numPlayers + " please enter your names.");
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Enter name: ");
			players.add(new Player(sc.nextLine()));
		}
	}

	private void drawCards() {
		ListIterator<Player> iterator = players.listIterator();
		while (iterator.hasNext()) {
			iterator.next().drawCard();
		}
	}

}
