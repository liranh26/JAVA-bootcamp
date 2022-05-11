package testingExercise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * @author Liran Hadad
 */
@TestInstance(Lifecycle.PER_CLASS)
class TshirtTest {

	static final double MIN_DEM_FACTOR, MAX_DEM_FACTOR, MIN_BASE_PRICE;
	
	static {
		MIN_DEM_FACTOR = 0.1;
		MAX_DEM_FACTOR = 1;
		MIN_BASE_PRICE = 3;
	}

	Tshirt tshirt;
	static String message = "Tests for Tshirt class";
	
	@BeforeAll
	static void startMessage() {
		System.out.println(message);
	}
	
	TshirtTest() {
		tshirt = new Tshirt();

	}

	@Test
	void checkConstructor() {
		assertEquals(tshirt.demenadFactor, MIN_DEM_FACTOR);
		assertEquals(tshirt.basePrice, MIN_BASE_PRICE);
		assertEquals(tshirt.size, ShirtSize.M);
	}
	
	@Test
	void checkBasePriceSetter() {
		tshirt.setBasePrice(-1);
		assertEquals(MIN_BASE_PRICE, tshirt.basePrice);
		tshirt.setBasePrice(50);
		assertEquals(50, tshirt.basePrice);
		tshirt.setBasePrice(3);
		assertEquals(MIN_BASE_PRICE, tshirt.basePrice);
	}
	
	@Test
	void checkIsExpensive() {
		assertTrue(tshirt.isExpensive());
	}
	
	@Test
	void checkCalculateFinalPrice() {
		double ans = (tshirt.basePrice + tshirt.design.complexity) * tshirt.design.calcuteArea() / tshirt.demenadFactor;
		assertEquals(ans, tshirt.calculateFinalPrice());
	}

	@AfterAll
	void end() {
		System.out.println("----------------");
		System.out.println("Done all testing.");
	}

}
