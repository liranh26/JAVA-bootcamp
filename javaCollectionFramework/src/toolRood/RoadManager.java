package toolRood;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

/**
 * @author Liran Hadad
 */
public class RoadManager {

	protected ToolRoad toolRoad;
	protected ArrayList<Car> cars;

	public RoadManager() {
		initializeToolRoad();
		initializeCars();
	}

	private void initializeToolRoad() {
		toolRoad = new ToolRoad();

		CheckPoint[] checkpoints = new CheckPoint[7];
		checkpoints[0] = new CheckPoint("Ashkelon", "address1", 0);
		checkpoints[1] = new CheckPoint("Ashdod", "address2", 1);
		checkpoints[2] = new CheckPoint("Yavne", "address3", 2);
		checkpoints[3] = new CheckPoint("Rishon", "address4", 3);
		checkpoints[4] = new CheckPoint("Holon", "address5", 4);
		checkpoints[5] = new CheckPoint("Tel avivo", "address6", 5);
		checkpoints[6] = new CheckPoint("Haifa", "address7", 6);

		for (CheckPoint checkPoint : checkpoints) {
			toolRoad.addCheckPoint(checkPoint);
		}
	}

	private void initializeCars() {
		cars = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			cars.add(new Car());
		}

		for (Iterator<Car> iterator = cars.iterator(); iterator.hasNext();) {
			Car car = (Car) iterator.next();
			car.enterPoint(getRandomPoint());
		}

	}

	public void run() {

		for (int i = 1; i <= 5; i++) {
			for (ListIterator<Car> iterator = cars.listIterator(); iterator.hasNext();) {
				Car car = (Car) iterator.next();

				switch (randomMove()) {
				case 0:
					moveForward(car);
					System.out.println(car);
					break;
				case 1:
					moveBackward(car);
					System.out.println(car);
				}
			}

			System.out.println("-------------------");
		}
		for (Iterator<Car> iterator = cars.iterator(); iterator.hasNext();) {
			Car car = (Car) iterator.next();
			car.exitRoad();
		}
	}

	private int randomMove() {
		Random rand = new Random();
		return rand.nextInt(2);
	}

	private void moveBackward(Car car) {
		if (toolRoad.hasPreviousPoint(car))
			car.driveNext(toolRoad.getPreviousPoint(car.currPoint));
		else
			System.out.println("You are at the end of the road amigo!");

	}

	private void moveForward(Car car) {
//		Iterator<CheckPoint> iterator = toolRoad.iterator(); // Not available here.. why ?
		if (toolRoad.hasNextPoint(car)) //
			car.driveNext(toolRoad.getNextPoint(car.currPoint));
		else
			System.out.println("You are at the end of the road amigo!");
	}

	private CheckPoint getRandomPoint() {
		Random rand = new Random();
		int index = rand.nextInt(6);
		return toolRoad.getPointByIndex(index);
	}

}
