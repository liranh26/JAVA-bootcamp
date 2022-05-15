package command;

import java.time.LocalDateTime;

public class OffCommand implements Command {

	protected LocalDateTime excuteTime;
	
	@Override
	public void excute() {
		turnOff();
		
	}

	private LocalDateTime turnOff( ) {
		excuteTime = LocalDateTime.now();
		return excuteTime;
	}


	
	
}
