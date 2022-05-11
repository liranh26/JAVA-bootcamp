package solid_liskov_substitution;

public abstract class Apartment extends Home{
	
    public int numberOfBedrooms;

    abstract void setNumberOfBedrooms(int numberOfBedrooms);
}
