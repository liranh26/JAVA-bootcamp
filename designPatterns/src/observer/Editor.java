package observer;

public class Editor {

	public EventManager events;

	public Editor() {
		this.events = new EventManager(ReportType.GENERAL, ReportType.SPORT, ReportType.WEATHER);
	}

	public void send(ReportType reportType, String report) {

		events.notify(reportType, report);
	}

}
