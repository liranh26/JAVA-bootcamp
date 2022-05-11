package bootcamp.oop.basic;

public class Runner {

	public static void main(String[] args) {
//		Clock clk1 = new Clock(100);
////		clk1.timeInMin = 100;
//		clk1.printTime();
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		player1.eatBonus();
		player1.hitObstacle();
		player1.hitObstacle();
		
		player2.eatBonus();
		
	}

}
