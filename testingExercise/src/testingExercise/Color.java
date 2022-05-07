package testingExercise;

/**
 * @author Liran Hadad
 */
public class Color {
	private static final short MIN_VALUE = 0;
	private static final short MAX_VALUE = 255;
	protected short red;
	protected short green;
	protected short blue;

	public Color() {
		this(MIN_VALUE, MIN_VALUE, MIN_VALUE);
	}
	
	public Color(int red, int green, int blue) {
		this((short)red, (short)green, (short) blue);
	}

	public Color(short red, short green, short blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}

	protected String getDomninat() {

		if (red > green && red > blue)
			return "red";
		if (green > blue && green > red)
			return "green";
		else
			return "blue";

	}

	protected void setRed(short red) {
		if (red >= MIN_VALUE && red <= MAX_VALUE)
			this.red = red;
		else
			this.red = MIN_VALUE;
	}

	protected void setGreen(short green) {
		if (green >= MIN_VALUE && green <= MAX_VALUE)
			this.green = green;
		else
			this.green = MIN_VALUE;
	}

	protected void setBlue(short blue) {
		if (blue >= MIN_VALUE && blue <= MAX_VALUE)
			this.blue = blue;
		else
			this.blue = MIN_VALUE;
	}

	/**
	 * 
	 * @return normlized array. cells by the rgb concept
	 */
	protected float[] normalized() {
		float[] normalizedColors = new float[3];

		normalizedColors[0] = red / MAX_VALUE;
		normalizedColors[1] = green / MAX_VALUE;
		normalizedColors[2] = blue / MAX_VALUE;

		return normalizedColors;
	}	

	public static short getMinValue() {
		return MIN_VALUE;
	}

	public static short getMaxValue() {
		return MAX_VALUE;
	}

	@Override
	public String toString() {
		return "Color [red=" + red + ", green=" + green + ", blue=" + blue + "]";
	}
}
