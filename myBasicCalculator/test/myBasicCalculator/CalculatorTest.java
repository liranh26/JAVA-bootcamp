package myBasicCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import myBasicCalculator.Calculator.Operation;

/**
*@author Liran Hadad
*/

@DisplayName("Calcutor class tests")
class CalculatorTest {

	private final int CONSTRUCTOR1 = 2;

	private Calculator calculator1;
	
	public CalculatorTest() {
		calculator1 = new Calculator(2);
	}
	
	
	@Test
	@DisplayName("constructor1.answer should be " +CONSTRUCTOR1)
	void checkConstructor() {
		int actual = calculator1.answer;
		int expected = CONSTRUCTOR1;
		assertEquals(expected, actual);
	}

	@Test
	void checkSum() {
		calculator1.sum(3, 5);
		assertNotEquals(9, calculator1.answer);
		assertTrue(calculator1.lastOperation == Operation.ADD);
	}
	
	@Test
	void checkOperation() {
		assertNull(calculator1.lastOperation);
	}
	
	@Test
	void checkArray() {
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,2,3};
	
		assertArrayEquals(arr1, arr2);
	}
	
	@Test
	void checkDivision() {
		
		assertThrows(ArithmeticException.class, ()->calculator1.divide(10, 0));
		assertDoesNotThrow(()->calculator1.divide(10, 10));
	}
	
	@Test
	@Disabled
	void checkDuration() {
		assertTimeout(Duration.ofMillis(200), ()->{
			Thread.sleep(100);
			return 2;
		});
	}
	
	
	
}
