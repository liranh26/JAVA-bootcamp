package state;

public class Balance25 extends State {
	
	Balance25(MachineGum machine) {
		super(machine);
	}

	@Override
	public void updateBy5() {
		System.out.println("Collect your Gum.");
	}

	@Override
	public void updateBy10() {
		System.out.println("Collect your Gum.");
	}

	@Override
	public void collectGum() {
		System.out.println("YAM YAM, your balance is reset to 0.");
		machine.changeState(new Balance0(machine));
	}

	@Override
	public void displayBalance() {
		System.out.println("The balance is 25.");

	}

}
