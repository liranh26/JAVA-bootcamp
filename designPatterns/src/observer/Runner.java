package observer;

public class Runner {

	public static void main(String[] args) {
		
		Editor editor = new Editor();
		editor.events.subscribe(ReportType.SPORT, new SmsListener(45454545));
		editor.events.subscribe(ReportType.SPORT, new EmailListener("demo@gmail.com"));

		EmailListener listner = new EmailListener("demo2@gmail.com");
		editor.events.subscribe(ReportType.SPORT, listner);
		editor.events.unsubscribe(ReportType.SPORT, listner);
		
		editor.events.subscribe(ReportType.GENERAL, new SmsListener(545332205));
		editor.events.subscribe(ReportType.GENERAL, new EmailListener("demo@gmail.com"));
		
		editor.events.subscribe(ReportType.WEATHER, new SmsListener(8888));
		editor.events.subscribe(ReportType.WEATHER, new EmailListener("demo@gmail.com"));
		
		editor.send(ReportType.SPORT, "Wariors Won!");
		editor.send(ReportType.GENERAL, "peace!");
		editor.send(ReportType.WEATHER, "Valcano errapt!");
		
	}
}
