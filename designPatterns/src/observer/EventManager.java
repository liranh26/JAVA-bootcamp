package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
	
	protected Map<ReportType, ArrayList<EventListeners>> listeners = new HashMap<>();
	
	public EventManager(ReportType ... reportTypes){
		for (ReportType reportType : reportTypes) {
			listeners.put(reportType, new ArrayList<EventListeners>());
		}
	}
	
    public void subscribe(ReportType reportType, EventListeners listener) {
        List<EventListeners> users = listeners.get(reportType);
        users.add(listener);
    }

    public void unsubscribe(ReportType reportType, EventListeners listener) {
        List<EventListeners> users = listeners.get(reportType);
        users.remove(listener);
    }

    public void notify(ReportType reportType, String report) {
    	reportType.insertReport(report);
        List<EventListeners> users = listeners.get(reportType);
        for (EventListeners listener : users) {
            listener.update(reportType);
        }
    }
	
}
