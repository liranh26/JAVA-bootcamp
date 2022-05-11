package toolRood;

/**
 * @author Liran Hadad
 */
public class Car {

	private int totalBill;
	private final int checkPointPrice = 5;
	private static int plateNumberIndex = 0;
	protected final int plateNumber;
	protected CheckPoint currPoint;

//	protected ListIterator<CheckPoint> iterator;

	public Car() {
		totalBill = 0;
		plateNumber = plateNumberIndex++;
	}
	
	public void enterPoint(CheckPoint enterPoint) {
		currPoint = enterPoint;
		System.out.println("Welcome to Tool road, you entered at "+currPoint.address);
		totalBill += checkPointPrice;
	
	}

	public void driveNext(CheckPoint nextPoint) {
			currPoint = nextPoint;
			totalBill += checkPointPrice;
			System.out.println("You arrived to" + currPoint.address);
		
			
	}

	public int exitRoad() {
		System.out.println("Your Bill for the drive is: "+getBill()+"\nAdios, See You Again Soon!");
		return getBill();
	}
	
	private int getBill() {
		return totalBill;
	}

	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber +", totalBill=" + totalBill + ", currPoint=" + currPoint + "]";
	}

}
