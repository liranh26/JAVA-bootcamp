package observer;

public enum ReportType {

	SPORT, WEATHER, GENERAL;

	public String report;
	
	void insertReport(String report){
		this.report = report;
	}
	
	String printReport() {
		return "Report: " + report;
	}
	
}

