package adapter;

/**
 * RoundPegs are compatible with RoundHoles.
 */
public class Sparrow {
	public String sound;
	public String fly;

    public Sparrow() {
    	this("Chrip Chrip", "Flying");
    }

    public Sparrow(String sound, String fly) {
        this.sound = sound;
        this.fly = fly;
    }

	@Override
	public String toString() {
		return "Sparrow: " + sound + "\nSparrow:" + fly;
	}

}