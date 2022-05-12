package builder;

public class Runner {

	 public static void main(String[] args) {
		 
	        Director director = new Director();

	        // Director gets the concrete builder object from the client
	        // (application code). That's because application knows better which
	        // builder to use to get a specific product.
	        PizzaBuilder pizzaBuilder = new PizzaBuilder();
	        director.constructHawaiianPizza(pizzaBuilder);

	        // The final product is often retrieved from a builder object, since
	        // Director is not aware and not dependent on concrete builders and
	        // products.
	        Pizza pizza = pizzaBuilder.getResult();
	        System.out.println("Pizza created: " + pizza.getPizzaType());
	        
	        director.constructDominicamPuffPastry(pizzaBuilder);
	        Pizza puffPastry = pizzaBuilder.getResult();
	        System.out.println("Pizza created: " + puffPastry.getPizzaType());

	        
	        RecipeBuilder recipeBuilder = new RecipeBuilder();

	        // Director may know several building recipes.
	        director.constructHawaiianPizza(recipeBuilder);
	        Recipe hawaiianPizzaRecipe = recipeBuilder.getResult();
	        System.out.println(hawaiianPizzaRecipe);
	        
	        director.constructDominicamPuffPastry(recipeBuilder);
	        Recipe puffPastryRecipe = recipeBuilder.getResult();
	        System.out.println(puffPastryRecipe);
	    }

}
