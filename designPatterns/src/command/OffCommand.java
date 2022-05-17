package command;


import java.time.LocalTime;

public class OffCommand implements Command {

	
	
	@Override
	public String excute() {
		return "Heater turned off on %s".formatted(LocalTime.now());
		
	}

	
}
