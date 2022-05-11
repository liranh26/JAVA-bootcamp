package bootcamp.oop.umlLesson;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Liran Hadad
 */
public class Flight {
	private final int FLIGHT_NUMBER;
	private static int flightId = 0;
	protected int flightDuration;
	protected LocalTime departureTime;
	protected LocalDate departureDate;
	private int minutesOfDelay = 0;
	protected FrequentFlyer[] frequentFlyers = new FrequentFlyer[200];
	protected int flightMile;

	Flight(int flightDuration, LocalTime departureTime, LocalDate departureDate, int flightMile) {
		this.FLIGHT_NUMBER = flightId++;
		setDepartureTime(departureTime);
		setDepartureDate(departureDate);
		this.flightDuration = flightDuration;
		this.flightMile = flightMile;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public int getFlightNumber() {
		return FLIGHT_NUMBER;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getLandingTime() {
		return departureTime.plusMinutes(flightDuration + minutesOfDelay);
	}

	public void delay(int delayAmount) {
		minutesOfDelay += delayAmount;
	}

	public FrequentFlyer[] getFrequentFlyers() {
		return frequentFlyers;
	}

	public void setFrequentFlyer(FrequentFlyer frequentFlyer) {
		this.frequentFlyers[frequentFlyer.FF_NUM] = frequentFlyer;

	}

	
	
}
