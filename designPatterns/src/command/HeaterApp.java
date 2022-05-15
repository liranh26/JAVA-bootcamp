package command;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

public class HeaterApp {

	protected Deque<Command> history;
	protected OffCommand off;
	protected OnCommand on;
	private final int MAX_WORK_TIME = 90;

	public HeaterApp() {
		history = new ArrayDeque<>();
		off = new OffCommand();
		on = new OnCommand();
	}

	public void turnOn(int workTime) {
		if (workTime > MAX_WORK_TIME)
			workTime = 90;
		on.excute();
		System.out.println("Heater turned on for" + workTime + "minutes on " + on.excuteTime);
		addCommand(on);
	}
	
	public void turnOff() {
		off.excute();
		System.out.println("Heater turned off on " + off.excuteTime);
	}

	public void addCommand(Command com) {
		if (history.size() < 5)
			history.addFirst(com);
		else {
			history.addFirst(com);
			history.pollLast();
		}

	}

	public void showHistory() {
		System.out.println(history);
		
	}
}
