package adapter;
/**
 * SquarePegs are not compatible with RoundHoles (they were implemented by
 * previous development team). But we have to integrate them into our program.
 */
public class PlasticToyDuck {
	
    private String sound;
    
    public PlasticToyDuck() {
    	this("PlasticToyDuck is squeaking");
    }

    public PlasticToyDuck(String sound) {
        this.sound = sound;
    }
    
    public void squeak() {
    	System.out.println(sound);
    }

}