package builder;

/**
 * Unlike other creational patterns, Builder can construct unrelated products,
 * which don't have the common interface.
 *
 */
public class RecipeBuilder implements Builder{
    private PizzaType type;
    private int mozzarela, feta, mushrooms, pineapple;
    
    
    @Override
    public void setPizzaType(PizzaType type) {
    	this.type = type;
    }


    @Override
    public void setMozzarela(int mozzarela) {
    	this.mozzarela = mozzarela;
    }

    @Override
    public void setFetaCheese(int feta) {
    	this.feta = feta;
    }

    @Override
    public void setMushrooms(int mushrooms) {
    	this.mushrooms = mushrooms;
    	
    }

    @Override
    public void setPineapple(int pineapple) {
    	this.pineapple = pineapple;
    }

    public Recipe getResult() {
        return new Recipe(type, mozzarela, feta, mushrooms, pineapple);
    }





}