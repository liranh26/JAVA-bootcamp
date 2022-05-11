package bootcamp.oop.exercise;

import java.time.LocalTime;

public interface Appliable {
	public LocalTime turnOn();
	public long turnOffSec(LocalTime on);
}
