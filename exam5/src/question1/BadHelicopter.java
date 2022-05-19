package question1;

public class BadHelicopter {

	
	public String yawRight() {
		return "Helicopter yaws to right ... ";
	}
	
	public String yawLeft() {
		return "Helicopter yaws to left ... ";
	}
	
	public String flyUp() {
		return "Helicopter flies up ... ";
	}
	
	public String flyDown() {
		return "Helicopter flies down ... ";
	}
	
	public String luanchMissile() {
		return "luanch Missile! ... ";
	}

	@Override
	public String toString() {
		return "BadHelicopter [yawRight()=" + yawRight() + ", yawLeft()=" + yawLeft() + ", flyUp()=" + flyUp()
				+ ", flyDown()=" + flyDown() + ", luanchMissile()=" + luanchMissile() + "]";
	}
	
	
	

}
