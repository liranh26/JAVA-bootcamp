package state;

public class Balance20 extends State {

	Balance20(MachineGum machine) {
		super(machine);
	}

	@Override
	public void updateBy5() {
		machine.changeState(new Balance25(machine));

	}

	@Override
	public void updateBy10() {
		System.out.println("Your balance left is 5 cent.\n insert valid coin.");

	}

	@Override
	public void collectGum() {
		System.out.println("Your balance missing 5 cents!");

	}

	@Override
	public void displayBalance() {
		System.out.println("The balance is 20.");

	}

}
