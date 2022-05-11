package bootcamp.oop.exercise;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import bootcamp.oop.exeRemotControl.RemoteConrtol;


public class Television extends HomeAppliance implements Flatable, Smartable, Appliable {
	
	protected float size;
	protected String model;
	protected RemoteConrtol remote;
	
	//constructors
	
	public Television(String manufacturer , int purchaseYear, float size, String remTransmitMethod, int powerConsumption){
		super(manufacturer, purchaseYear, powerConsumption);
		setSize(size);
		setModel("A12");
		remote = new RemoteConrtol(remTransmitMethod);

	}
	
	public Television(float size) {
		this("Generic", (Calendar.getInstance()).get(Calendar.YEAR), size, "RF", 150);
	}
	
	public Television() {
		this(40);
	}
	
	
	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		if (size < 2.5f || size > 120f)
			size = 10f;
		this.size = size;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		
		if (model.length()<3) {
			System.out.println("Exception in setModel");
			return;
		}
			
		char ch = model.charAt(0);
		if(!Character.isLetter(ch))
			model = "A"+model;
		
		char ch1 = model.charAt(1);
		char ch2 = model.charAt(2);
		if(!Character.isDigit(ch1) || !Character.isDigit(ch2)) {
			model = ch+"00";
		}
		
		model = model.substring(0, 3);
		this.model = model;
	}


	@Override
	public String toString() {
		return "Television [size=" + size + ", model=" + model +" totalPowerConsumption: "+powerConsumption + " remote method " + remote.getTransmitMethod() +" "+ super.toString() + "]";
	}


	public float sizeInCM() {
		return size*2.54f;
	}
	
	public int isBigger(Television other) {
		float diff = this.size-other.size;
		if(diff>0)
			return 1;
		else if(diff<0)
			return -1;
		else
			return 0;
	}

	@Override 
	public int getTotalPowerConsumption(int hours) {
		return this.powerConsumption * hours;
	}
	
	
	@Override
	public boolean isSmart() {
		return this.purchaseYear > 2017;
	}
	
	@Override
	public boolean isFlat() {
		return this.purchaseYear > 2015;
	}
	
	@Override
	public LocalTime turnOn() {
		return LocalTime.now();  
	}
	
	@Override
	public long turnOffSec(LocalTime on) {
	    long minutes = ChronoUnit.MINUTES.between(on, LocalTime.now());  
		
		return minutes;  
	}
}
