package toolRood;
/**
*@author Liran Hadad
*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ToolRoad {
	
	protected LinkedList<CheckPoint> toolRoad;

	
	public ToolRoad() {
		toolRoad = new LinkedList<>();
	}
	
	protected void addCheckPoint(CheckPoint checkPoint) {
		toolRoad.add(checkPoint);
	}

	public LinkedList<CheckPoint> getToolRoad() {
		return toolRoad;
	}

	protected void removeCheckPoint(CheckPoint point) {
		Iterator<CheckPoint> iterator = toolRoad.iterator();
		while(iterator.next() != point);
		iterator.remove();
	}
	
	public CheckPoint getPointByIndex(int index) {
		for (Iterator<CheckPoint> iterator = toolRoad.iterator(); iterator.hasNext();) {
			CheckPoint checkPoint = (CheckPoint) iterator.next();
			if(checkPoint.getPosition() == index)
				return checkPoint;
		}
		return null;
	}

	private ListIterator<CheckPoint> iteratorOnPointByCar(CheckPoint currPoint){
		for (ListIterator<CheckPoint> iterator = toolRoad.listIterator(); iterator.hasNext();) {
			CheckPoint checkPoint = (CheckPoint) iterator.next();
			if(currPoint == checkPoint)
				return iterator;
		}
		return null;
	}
	
	public boolean hasNextPoint(Car car) {
		ListIterator<CheckPoint> iterator = iteratorOnPointByCar(car.currPoint); 
		if(iterator == null )
			return false;
		if(iterator.hasNext())
			return true;

		return false;
	}
	
	public CheckPoint getNextPoint(CheckPoint currPoint) {
		ListIterator<CheckPoint> iterator = iteratorOnPointByCar(currPoint); 
		if(iterator == null )
			return null;
		if(iterator.hasNext())
			return (CheckPoint) iterator.previous();
		
		return null;
	}
	
	
	public boolean hasPreviousPoint(Car car) {
		
		ListIterator<CheckPoint> iterator = iteratorOnPointByCar(car.currPoint); 
		if(iterator == null )
			return false;
		if(iterator.hasPrevious() && iterator.previousIndex() != 0)
			return true;
	
		return false;
	}
	
	public CheckPoint getPreviousPoint(CheckPoint currPoint) {
		
		ListIterator<CheckPoint> iterator = iteratorOnPointByCar(currPoint); 
		if(iterator == null )
			return null;
		if(iterator.hasPrevious() && iterator.previousIndex() != 0) {
			iterator.previous();
			return (CheckPoint) iterator.previous();
		}
		
		return null;
	}
	
	
	@Override
	public String toString() {
		return "ToolRoad [toolRoad=" + toolRoad +"]";
	}
	
	
}
