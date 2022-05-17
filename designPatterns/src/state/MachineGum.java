package state;

public class MachineGum {

	private State state;

	public MachineGum() {
		System.out.println("Welcome to the Gum dispenser Simulator.");
		state = new Balance0(this);
	}

	public void start() {
		int input=0;
		while (input != 4) {
			printMenu();
			switch(input = ScannerInput.getIntFromUser()) {
			case 1:
				state.updateBy5();
				break;
			case 2:
				state.updateBy10();;
				break;
			case 3:
				state.collectGum();
				break;
			case 4:
				input = 4;
				System.out.println("Bye Bye!");
			}
		}
	}

	public void changeState(State state) {
		this.state = state;
	}
	
	private void printMenu() {
		state.displayBalance();
		String message = "Please enter:\n" + "1 - if you're inserting a 5 cents coin\n"
				+ "2 - if you're inserting a 10 cents coin\n" + "3 - To collect the gun...\n" 
					+ "4 - Exit.";
		System.out.println(message);
	}
	

}
