package bootcamp.oop.umlLesson;
/**
*@author Liran Hadad
*/
public class MileageCredit {

	private int baseMiles;
	private int bonusMiles;
	protected int credit;
	
	public MileageCredit(int baseMiles, int bonusMiles, Flight flight, int ffNum) {
		this.baseMiles = flight.flightMile;
		this.bonusMiles = bonusMiles;
		setCredit(flight, ffNum);
	}
	
	private void setCredit( Flight flight, int ffNum) {
		flight.frequentFlyers[ffNum].milesCredit += baseMiles + bonusMiles;
	}
	
	
	
}
