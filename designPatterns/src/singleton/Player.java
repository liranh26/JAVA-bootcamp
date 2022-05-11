package singleton;

import java.util.Random;

public class Player {
	String name;
	private static int id;
	private static int idcounter=0;
	private int card;
	private int points;
	
	public Player(String name) {
		id = idcounter++;
		this.name = name;
		card = 0;
		points = 0;
	}

	public static int getId() {
		return id;
	}

	public static int randomNumPlayers() {
		Random rand = new Random();
		return rand.nextInt(3)+2;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points += points;
	}
	
	public void drawCard() {
		setCard(CardPack.getCard());
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", points=" + points + "]";
	}

}
