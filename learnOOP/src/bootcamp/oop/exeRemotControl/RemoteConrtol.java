package bootcamp.oop.exeRemotControl;

public class RemoteConrtol {
	
//	public static final String METHOD1, METHOD2;
	private String transmitMethod;
	
//	static {
//		METHOD1 = "RF";
//		METHOD2 = "IR";
//	}
	
	public RemoteConrtol(){
		setTransmitMethod("METHOD1");
	}
	
	public RemoteConrtol(String transmitMethod) {
		setTransmitMethod(transmitMethod);
	}
	
	public void setTransmitMethod(String transmitMethod) {
		if(transmitMethod == "IR" || transmitMethod == "RF")
			this.transmitMethod = transmitMethod;
		else
			System.out.println("The transmit method inserted is not valid!");
	}

	public String getTransmitMethod() {
		return transmitMethod;
	}
	
	
	
	
	
}
