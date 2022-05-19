package question1;

public class BadHelicopterAdapter implements EnemyFigure {

	private BadHelicopter badHelicopter;
	
	public BadHelicopterAdapter(BadHelicopter badHelicopter) {
		this.badHelicopter = badHelicopter;
	}
	
	
	@Override
	public String turnRight() {
		return badHelicopter.yawRight();
	}

	@Override
	public String turnLeft() {
		return badHelicopter.yawLeft();
	}

	@Override
	public String driveForward() {
		return badHelicopter.flyUp();
	}

	@Override
	public String driveBackward() {
		return badHelicopter.flyDown();
	}

	@Override
	public String fire() {
		return badHelicopter.luanchMissile();
	}

	
	
}
