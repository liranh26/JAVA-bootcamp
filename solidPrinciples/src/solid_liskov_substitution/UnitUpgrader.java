package solid_liskov_substitution;

public class UnitUpgrader {

	public void upgrade(Apartment apartment) {
		apartment.squareFootage += 40;
		apartment.numberOfBedrooms += 1;
	}
}
