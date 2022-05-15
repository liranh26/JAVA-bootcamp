package command;

import java.time.LocalDateTime;

public class CommandHistory {

	protected Command command;
	
	public CommandHistory(Command command) {
		this.command = command;
	}
	
	@Override
	public String toString() {
		return "Heater" + command + ", at time= ";
	}
	
}
