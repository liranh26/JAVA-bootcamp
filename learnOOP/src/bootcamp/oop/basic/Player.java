package bootcamp.oop.basic;

public class Player {
	
	//fields
	private int points = 0;
	private int lives = 3;
	
	public static int totalPoints ,numPlayers;

	static {
		totalPoints = 0;
		numPlayers = 1;
	}
	
	//constructor
	public Player() {
		this.setPoints(0);
		this.setlives(3);
	}
	
	//methods
	private void setPoints(int points) {
		this.points += points;
		totalPoints += points;
		
		if(this.points < 0) {
			this.points = 0;
		}
		
	}
	
	
	private void setlives(int lives) {
		if(lives < 6 && lives > 0)
			this.lives = lives;
		else if(lives==0) {
			numPlayers--;
		}
	}
	
	
	public void eatBonus() {
		int bonus = (int)(Math.random()*2)*50 + 100;
		System.out.println("Bonus " +bonus+"!");
		addPoints(bonus);
	}
	
	
	public void hitObstacle() {
		int subtract = (int)(Math.random()*2)*(-100) - 100;
		System.out.println("Subtract " +subtract+"!");
		subtractPoints(subtract);
	}
	
	
	private void addPoints(int numPoints) {
		setPoints(numPoints);
		
		if(this.points > 150 && this.lives < 5) {
			setPoints(this.points-150);
			setlives(this.lives+1);
		}
		
	}
	
	private void subtractPoints(int numPoints) {
		setPoints(numPoints);
		
		if(this.points < 100) 
			setlives(this.lives-1);	
	}
	
	
}
