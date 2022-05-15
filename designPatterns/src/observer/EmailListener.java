package observer;

public class EmailListener implements EventListeners {

	protected String email;
	
	EmailListener (String email){
		this.email = email;
	}

	@Override
	public void update(ReportType type) {
		System.out.println(type + " new report sent to email " + email +" " + type.printReport());
		
	}
	
	
	
}
