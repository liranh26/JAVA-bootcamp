package solid_liskov_substitution;

public class PenthouseSuite extends Apartment{
	
    public PenthouseSuite() {
    	setNumberOfBedrooms(4);
    }

    @Override
    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }

	@Override
	void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
		
	}
    
    
	  
}
