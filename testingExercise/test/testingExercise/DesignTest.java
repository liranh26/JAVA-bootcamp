package testingExercise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
*@author Liran Hadad
*/

@TestInstance(Lifecycle.PER_CLASS)
class DesignTest {
	
	private static final int MIN_WIDTH, MAX_WIDTH, MIN_HIEGHT, MAX_HIEGHT;
	private static final String DEF_SLOGAN = "Hola";
	static {
		MIN_WIDTH = 20;
		MAX_WIDTH = 30;
		MIN_HIEGHT = 10;
		MAX_HIEGHT = 25;
	}
	
	Design design;
	static String message = "Tests for Deisgn class";
	
	
	@BeforeAll
	static void startMessage() {
		System.out.println(message);
	}
	
	DesignTest(){
		design = new Design();
	}
	
	
	
	@Test
	@DisplayName("checks the default constuctor")
	void checkDefaultConstructor() {
		assertEquals(design.width, MIN_WIDTH);
		assertEquals(design.hieght, MIN_HIEGHT);
		assertEquals(design.slogan, DEF_SLOGAN);
		assertEquals(design.color.blue, new Color().blue);
		assertEquals(design.color.green, new Color().green);
		assertEquals(design.color.red, new Color().red);
	}
	
	@Test
	@DisplayName("checks the hieght setter")
	void checkHieghtSetter() {
		design.setHieght(MAX_HIEGHT);
		assertEquals(MAX_HIEGHT, design.hieght);
		design.setHieght(MIN_HIEGHT);
		assertEquals(MIN_HIEGHT, design.hieght);
		design.setHieght(3);
		assertEquals(MIN_HIEGHT, design.hieght);
	}
	
	@Test
	@DisplayName("checks the width setter")
	void checkWidthSetter() { 
		design.setWidth(MAX_WIDTH);
		assertEquals( MAX_WIDTH, design.width);
		design.setWidth(MIN_WIDTH);
		assertEquals(MIN_WIDTH, design.width);
		design.setWidth(3);
		assertEquals(MIN_WIDTH, design.width);
	}
	
	@Test
	@DisplayName("checks the slogan setter")
	void checkSloganSetter() { 
		design.setSlogan("Hakona Matata");
		assertEquals("Hakona Matata", design.slogan);
		design.setSlogan("hi there 123");
		assertEquals("hi there 123", design.slogan);
		design.setSlogan("hi^$");
		assertEquals( DEF_SLOGAN, design.slogan);   // if moved first it fails..
	}
	
	@Test
	void colorSetter() {
		assertNotNull(design.color);
	}
	
	@Test
	void checkAreaCalc() {
		assertEquals(design.width * design.hieght, design.calcuteArea());	
	}
	
	@AfterAll
	void end() {
		System.out.println("----------------");
		System.out.println("Done all testing.");
	}

}
