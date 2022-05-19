package question1;

public class EnemyTank implements EnemyFigure{

	@Override
	public String turnRight() {
		
		return "Tank is turnning right ... ";
	}

	@Override
	public String turnLeft() {
		return "Tank is turnning left ... ";
	}

	@Override
	public String driveForward() {
		return "Tank is moving forward ... ";
	}

	@Override
	public String driveBackward() {
		return "Tank is moving backward ... ";
	}

	@Override
	public String fire() {
		return "Tank FIRES!";
	}

	@Override
	public String toString() {
		return "EnemyTank [turnRight()=" + turnRight() + ", turnLeft()=" + turnLeft() + ", driveForward()="
				+ driveForward() + ", driveBackward()=" + driveBackward() + ", fire()=" + fire() + "]";
	}

}
