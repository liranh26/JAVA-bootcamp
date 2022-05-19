package question1;

public class Runner {

	public static void main(String[] args) {

		/** Using Adapter design pattern to configure badHelicopter to our interface **/
		
		EnemyTank tank1 = new EnemyTank();
		System.out.println("----------- Enemy Tank -----------");
		System.out.println(tank1.driveForward() + tank1.fire() +"\n");

		BadHelicopter helicopter = new BadHelicopter();
		System.out.println("----------- \"Old\" Incompatible Bad Helicopter -----------");
		System.out.println(helicopter.flyUp() + helicopter.luanchMissile() +"\n");
		
		BadHelicopterAdapter helicopterAdapter = new BadHelicopterAdapter(helicopter);
		System.out.println("----------- Interface Compatible Bad Helicopter -----------");
		System.out.println(helicopterAdapter.driveForward() + helicopterAdapter.fire() +"\n");
		
	}

}
