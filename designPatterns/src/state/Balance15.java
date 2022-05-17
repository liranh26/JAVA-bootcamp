package state;

public class Balance15 extends State {

	Balance15(MachineGum machine) {
		super(machine);
	}

	@Override
	public void updateBy5() {
		machine.changeState(new Balance20(machine));

	}

	@Override
	public void updateBy10() {
		machine.changeState(new Balance25(machine));

	}

	@Override
	public void collectGum() {
		System.out.println("Your balance missing 10 cents!");

	}

	@Override
	public void displayBalance() {
		System.out.println("The balance is 15.");

	}
}
