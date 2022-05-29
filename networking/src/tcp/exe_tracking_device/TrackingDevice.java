package tcp.exe_tracking_device;

public class TrackingDevice {

	private static int id;
	private Location location;
	
	public TrackingDevice() {
		id++;
		this.location = null;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public static int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "TrackingDevice : " + location + ", id: "+ id +"]";
	}
	
	
	
	
}
