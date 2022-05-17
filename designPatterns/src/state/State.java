package state;

public abstract class State {

	MachineGum machine;

	State(MachineGum machine) {
		this.machine = machine;
	}
	
	public abstract void updateBy5();
	public abstract void updateBy10();
	public abstract void collectGum();
	public abstract void displayBalance();
	
}
