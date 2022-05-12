package adapter;

public class Runner {
	
	public static void main(String[] args) {
		
		Sparrow sparrow = new Sparrow();

		System.out.println(sparrow);

		PlasticToyDuck toyDuck = new PlasticToyDuck();
		toyDuck.squeak();

		BirdToToyDuckAdapter sparrowToy = new BirdToToyDuckAdapter(sparrow);

		sparrowToy.squeak();
	}
}
