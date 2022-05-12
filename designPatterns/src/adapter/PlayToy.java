package adapter;
/**
 * RoundHoles are compatible with RoundPegs.
 */
public class PlayToy {
	PlasticToyDuck toyDuck;

    public PlayToy(PlasticToyDuck toyDuck) {
        this.toyDuck = toyDuck;
    }

    public void play() {
        toyDuck.squeak();
    }

}
