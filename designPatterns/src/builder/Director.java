package builder;

/**
 * Director defines the order of building steps. It works with a builder object
 * through common Builder interface. Therefore it may not know what product is
 * being built.
 */
public class Director {
	
	private final int HAWAIIAN_MOZZARELA=100,HAWAIIAN_FETA=40,HAWAIIAN_MUSHROOMS=20, HAWAIIAN_PINEAPPLE=25;
	private final int PUFF_MOZZARELA=10,PUFF_FETA=100,PUFF_MUSHROOMS=20, PUFF_PINEAPPLE=15;
	
    public void constructHawaiianPizza(Builder builder) {
        builder.setPizzaType(PizzaType.HAWAIIN_PIZZA);
        builder.setMozzarela(HAWAIIAN_MOZZARELA);
        builder.setFetaCheese(HAWAIIAN_FETA);
        builder.setMushrooms(HAWAIIAN_MUSHROOMS);
        builder.setPineapple(HAWAIIAN_PINEAPPLE);
    }

    public void constructDominicamPuffPastry(Builder builder) {
        builder.setPizzaType(PizzaType.DOMINICAN_PUFF_PATSRY);
        builder.setMozzarela(PUFF_MOZZARELA);
        builder.setFetaCheese(PUFF_FETA);
        builder.setMushrooms(PUFF_MUSHROOMS);
        builder.setPineapple(PUFF_PINEAPPLE);
    }
    
}