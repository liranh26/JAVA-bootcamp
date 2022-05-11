package testingExercise;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
*@author Liran Hadad
*/

@TestInstance(Lifecycle.PER_CLASS)
class ColorTest {
	
	private Color[] colors;
	private static String message = "This tests are for Color class testing";
	
	
	@BeforeAll
	public static void startMessage() {
		System.out.println(message);
	}
	
	ColorTest(){
		colors = new Color[3];
		colors[0] = new Color(0, 20, 255);
		colors[1] = new Color(189, 78, -1);
		colors[2] = new Color(260, 74, 66);
	}
	
	@BeforeEach
	void beforeTest() {
		System.out.println();
		System.out.println("The colors value before the test are:");
		for (int i = 0; i < colors.length; i++) {
			System.out.println(colors[i]);
		}
	}
	
	@Test
	@DisplayName("array colors should not be null")
	void isNull() {
		assertNotNull(colors);
		for (Color color : colors) {
			assertNotNull(color);
		}
	}
	
	@Test
	@DisplayName("check fields initialzed by correct values")
	void checkColorFields() {
		int actualIndex = 0;
		short[] actualColors = {0, 20, 255, 189, 78, 0, 0, 74, 66};
		
		for (int i = 0; i < colors.length; i++) {
			assertEquals(colors[i].red, actualColors[actualIndex++]);
			assertEquals(colors[i].green, actualColors[actualIndex++]);
			assertEquals(colors[i].blue, actualColors[actualIndex++]);
		}
	}
	
	@Test
	@DisplayName("check dominant fields")
	void checkDominantColor() {
		String[] actualDominantColor = {"blue","red","green"};
		String[] dominantColors = new String[3];
		
		for (int i = 0; i < dominantColors.length; i++) {
			dominantColors[i] = colors[i].getDomninat();
		}
		
		assertArrayEquals(dominantColors, actualDominantColor);
	}
	
	@Test
	@DisplayName("check normalized color values")
	void checkNormalizedColors() {
		short[][] actualShortColors = { {0, 20, 255}, {189, 78, 0}, {0, 74, 66} };
		float[] actualColors = new float[3];
		for (int i = 0; i < actualShortColors.length; i++) {
			for (int j = 0; j < actualColors.length; j++) {
			actualColors[j] = actualShortColors[i][j] / 255;
			}
			assertArrayEquals(colors[i].normalized(), actualColors);
		}

	}
	
	@Test
	@DisplayName("checks min and max values")
	void checkMinAndMax() {
		assertEquals(Color.getMinValue(), 0);
		assertEquals(Color.getMaxValue(), 255);
	}
	
	
	@AfterEach
	void publish() {
		System.out.println();
		System.out.println("The colors value after the test are:");
		for (int i = 0; i < colors.length; i++) {
			System.out.println(colors[i]);
		}
	}
	
	@AfterAll
	void end() {
		System.out.println("----------------");
		System.out.println("Done all testing.");
	}
	

}
