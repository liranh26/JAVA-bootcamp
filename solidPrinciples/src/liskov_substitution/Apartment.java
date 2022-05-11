package liskov_substitution;

public abstract class Apartment {
    public int squareFootage;
    public int numberOfBedrooms;

    abstract void setSquareFootage(int sqft);
}
