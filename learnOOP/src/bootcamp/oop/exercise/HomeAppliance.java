package bootcamp.oop.exercise;

import java.util.Calendar;


public abstract class HomeAppliance {
	
	protected int powerConsumption;
	protected String manufacturer;
	protected int purchaseYear;
	
	
	//constructors
	
	public HomeAppliance(String manufacturer , int purchaseYear, int powerConsumption){
		setManufacturer(manufacturer);
		setPurchaseYear(purchaseYear);
		setPowerConsumption(powerConsumption);
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setPowerConsumption(int powerConsumption) {
		this.powerConsumption = powerConsumption;
	}
	
	public void setManufacturer(String manufacturer) {
		if (manufacturer!=null) {
			this.manufacturer = manufacturer.toUpperCase();
		}
	}
	
	public int getPurchaseYear() {
		return purchaseYear;
	}
	
	public void setPurchaseYear(int purchaseYear) {
		int currYear = (Calendar.getInstance()).get(Calendar.YEAR);
		if(purchaseYear>1900 && purchaseYear<=currYear)
			this.purchaseYear = purchaseYear;
		else
			this.purchaseYear = currYear;
	}


	@Override
	public String toString() {
		return "HomeAppliance [powerConsumption=" + powerConsumption + ", manufacturer=" + manufacturer
				+ ", purchaseYear=" + purchaseYear + "]";
	}
	
	
	public abstract int getTotalPowerConsumption(int huors);
		
	
//	public String toString() {
//		return String.format(" [ Manufacturer: %s  Purchase Year: %d", manufacturer,purchaseYear);
//	}
	
	
}
