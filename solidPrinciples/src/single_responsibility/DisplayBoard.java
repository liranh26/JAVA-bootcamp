package single_responsibility;

import java.util.Iterator;
import java.util.List;

public class DisplayBoard {

	SolidBoard board;

	public void displayBoard(SolidBoard board) {

		this.board = board;
	}

	void display() {

		for (int i = 0; i < board.size * board.size; i++) {
			String borderOrNewLine = "";
			if ((i + 1) % board.size == 0) {
				borderOrNewLine += "\n";
				System.out.print(board.spots.get(i));
			} else {
				System.out.println();
			}
		}

	}
}
