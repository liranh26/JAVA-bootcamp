package exam3;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import exceptions.NonCapatilizedException;
import main.Food;
import main.Macronutrients;
import main.Taste;


@TestInstance(Lifecycle.PER_CLASS)
class FoodTest {
	
	private Food[] food;
	
	@BeforeAll
	void printBefaoreAll() {
		System.out.println("These are tests for Food class.");
	}
	
	FoodTest(){
		food = new Food[3];
		food[0] = new Food("Humus", Macronutrients.Protein, Taste.Sour);
		food[1] = new Food("Milkshake", Macronutrients.CarboHydrate, Taste.Sweet);
		food[2] = new Food("Gum", Macronutrients.Fat, Taste.Sour);
	}
	
	@Test
	@DisplayName("checks isFood method for given Food")
	void testIsDesert() {
		assertFalse(food[0].isDesert());
		assertTrue(food[1].isDesert());
	}
	
	@Test
	@DisplayName("checks setName method for given Food")
	void testSetName() {
		try {
			food[2].setName("Pita");
		} catch (NonCapatilizedException e) {
			System.out.println(e);
		}
		assertEquals("Pita", food[2].name);
	}
	

}
