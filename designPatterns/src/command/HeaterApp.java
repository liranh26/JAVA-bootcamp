package command;

import java.util.ArrayList;
import java.util.List;

public class HeaterApp {

	private final int SHOW_MAX_HISTORY = 5;
	protected ArrayList<String> history;
	protected OffCommand off;
	protected OnCommand on;

	public HeaterApp() {
		history = new ArrayList<>();
	}

	public void turnOn(int workTime) {
		executeCommand(new OnCommand(workTime));
	}

	public void turnOff() {
		executeCommand(new OffCommand());
	}

	private void executeCommand(Command command) {
		String message = command.excute();
		System.out.println(message);
		history.add(message);
	}

	public void addCommand(String com) {
		history.add(com);
	}

	public void showHistory() {
		List<String> lastCommands = new ArrayList<>(history);
		if (history.size() > SHOW_MAX_HISTORY)
			lastCommands = history.subList(history.size() - SHOW_MAX_HISTORY, history.size());
		lastCommands.forEach(command -> System.out.println(command));
	}
}
