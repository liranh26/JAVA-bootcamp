package state;

public class Balance5 extends State{
	
	Balance5(MachineGum machine) {
		super(machine);
	}

	@Override
	public void updateBy5() {
		machine.changeState(new Balance10(machine));
		
	}

	@Override
	public void updateBy10() {
		machine.changeState(new Balance15(machine));
	}

	@Override
	public void collectGum() {
		System.out.println("Your balance missing 20 cents!");
		
	}

	@Override
	public void displayBalance() {
		System.out.println("The balance is 5.");
		
	}

}
