package command;

import java.time.LocalTime;

public class OnCommand implements Command {
	
	int workTime;
	private final int MAX_WORK_TIME = 90;

	public OnCommand(int duration) {
		setWorkTime(duration);
	}
	
	private void setWorkTime(int workTime) {
		if (workTime > MAX_WORK_TIME || workTime <= 0)
			this.workTime = 90;
		else
			this.workTime = workTime;
	}

	@Override
	public String excute() {
		return "Heater turned on for %d minutes on %s".formatted(workTime, LocalTime.now());
	}

	
}
