package state;

public class Balance10 extends State {
	
	Balance10(MachineGum machine) {
		super(machine);
	}

	@Override
	public void updateBy5() {
		machine.changeState(new Balance15(machine));

	}

	@Override
	public void updateBy10() {
		machine.changeState(new Balance20(machine));

	}

	@Override
	public void collectGum() {
		System.out.println("Your balance missing 15 cents!");

	}

	@Override
	public void displayBalance() {
		System.out.println("The balance is 10.");

	}

}
