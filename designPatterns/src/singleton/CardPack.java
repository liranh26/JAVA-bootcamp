package singleton;

import java.util.ArrayList;
import java.util.Random;

public class CardPack {

	private static CardPack instance = null;
	public final static int NUM_CARDS=60;
	private static Random rand = new Random();
	public static ArrayList<Integer> cards;
	private static int cardsDraw;
	
	public static CardPack getInstance() {
		if (instance == null) {
			instance = new CardPack();
			initializeDeck();
		}

		return instance;
	}

	private CardPack() {
	}

	private static void initializeDeck() {
		cards = new ArrayList<>();
		for (int i = 1; i <= NUM_CARDS; i++) {
			cards.add(i);
		}
		cardsDraw = 0;
	}
	
	public static int getCard() {
		int cardIndex = rand.nextInt(CardPack.NUM_CARDS - cardsDraw++);
		return cards.remove(cardIndex);
	}
	
	
	
}
