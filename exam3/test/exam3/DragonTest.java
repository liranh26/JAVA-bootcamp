package exam3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import exceptions.TooYoungException;
import main.Dragon;

@TestInstance(Lifecycle.PER_CLASS)
class DragonTest {

	Dragon dragon;

	@BeforeAll
	void printBefaoreAll() {
		System.out.println("These are tests for Dragon class.");
	}

	DragonTest() {
		try {
			Dragon dragon = new Dragon("BlackWinged", LocalDate.of(500, 1, 1), 10);
		} catch (TooYoungException e) {
			System.out.println(e);
		}
	}

	@Test
	void testBirthdate() {
		assertEquals(500, dragon.getBirthdate().getYear());
		assertEquals(1, dragon.getBirthdate().getMonthValue());
		assertEquals(1, dragon.getBirthdate().getDayOfMonth());

	}
}
