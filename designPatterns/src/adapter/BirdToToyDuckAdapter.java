package adapter;

/**
 * Adapter allows fitting square pegs into round holes.
 */
public class BirdToToyDuckAdapter extends PlasticToyDuck {
    private Sparrow sparrow;

    public BirdToToyDuckAdapter(Sparrow sparrow) {
        this.sparrow = sparrow;
    }

    @Override
    public void squeak() {
    	System.out.println("This may sound like a bird but its a Toy duck squeaking:");
    	System.out.println("Sparrow: " + sparrow.sound );
    }
    
}