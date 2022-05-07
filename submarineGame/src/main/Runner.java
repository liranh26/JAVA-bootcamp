package main;

import boards.Game;

/**
 * @author Liran Hadad
 */
public class Runner {

	public static void main(String[] args) {
		Game game = new Game();

		game.play();

		game.reply();

	}

}
