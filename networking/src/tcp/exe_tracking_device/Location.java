package tcp.exe_tracking_device;

import java.time.LocalTime;

public class Location {

	private long longitude, altitude;
	private LocalTime time;
	
	public Location(long longitude, long altitude, LocalTime time) {
		this.longitude = longitude;
		this.altitude = altitude;
		this.time = time;
	}

	public long getLongitude() {
		return longitude;
	}

	public long getAltitude() {
		return altitude;
	}

	public LocalTime getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Location [longitude=" + longitude + ", altitude=" + altitude + ", time=" + time + "]";
	}
	
	
	
}
