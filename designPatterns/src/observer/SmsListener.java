package observer;

public class SmsListener implements EventListeners{
	
	protected int phoneNumber;
	
	SmsListener(int phone){
		phoneNumber = phone;
	}

	@Override
	public void update(ReportType type) {
		System.out.println(type + " new report sent SMS to phone " + phoneNumber +" " + type.printReport());
		
	}

}
