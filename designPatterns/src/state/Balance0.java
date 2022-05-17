package state;

public class Balance0 extends State {

	Balance0(MachineGum machine) {
		super(machine);
	}

	@Override
	public void updateBy5() {
		machine.changeState(new Balance5(machine));
	}

	@Override
	public void updateBy10() {
		machine.changeState(new Balance10(machine));
	}

	@Override
	public void collectGum() {
		System.out.println("Your balance missing 25 cents!");
		
	}

	@Override
	public void displayBalance() {
		System.out.println("The balance is 0.");
		
	}

}
