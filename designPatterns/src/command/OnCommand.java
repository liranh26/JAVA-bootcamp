package command;

import java.time.LocalDateTime;

public class OnCommand implements Command {
	
	protected LocalDateTime excuteTime;
	
	@Override
	public void excute() {
		turnOn();
	}

	private LocalDateTime turnOn() {
		excuteTime = LocalDateTime.now();
		return excuteTime;
	}

	
}
