package testingExercise;

import java.util.Random;

/**
 * @author Liran Hadad
 */
public class Design {
	private static final int MIN_WIDTH = 20;
	private static final int MAX_WIDTH = 30;
	private static final int MIN_HIEGHT = 10;
	private static final int MAX_HIEGHT = 25;
	private static final double MIN_COMPLEXITY = 1;
	private static final double MAX_COMPLEXITY = 100;
	protected double width;
	protected double hieght;
	protected String slogan;
	protected Color color;
	protected double complexity;
	protected static final String DEF_SLOGAN = "Hola";

	public Design() {
		this(MIN_WIDTH, MIN_HIEGHT, DEF_SLOGAN, new Color());
	}

	public Design(double width, double hieght, String slogan, Color color) {
		setWidth(width);
		setHieght(hieght);
		setSlogan(slogan);
		setColor(color);
		complexity();
	}

	protected void complexity() {
		Random random = new Random();
		double complexity = random.nextDouble(MAX_COMPLEXITY) + MIN_COMPLEXITY;

		this.complexity = complexity;
	}

	protected double calcuteArea() {
		return width * hieght;
	}

	protected void setWidth(double width) {
		if (width >= MIN_WIDTH && width <= MAX_WIDTH)
			this.width = width;
		else
			this.width = MIN_WIDTH;
	}

	protected void setHieght(double hieght) {
		if (hieght >= MIN_HIEGHT && hieght <= MAX_HIEGHT)
			this.hieght = hieght;
		else
			this.hieght = MIN_HIEGHT;
	}

	protected void setSlogan(String slogan) {
		if (isValid(slogan))
			this.slogan = slogan;
		else
			this.slogan = DEF_SLOGAN;
	}

	public void setColor(Color color) {
		if(color == null)
			this.color = new Color();
		this.color = color;
	}

	private boolean isValid(String str) {
		if(str == null)
			return false;
		
		for (int i = 0; i < str.length(); i++) {
			// checks whether the character is neither a letter nor a digit
			// if it is neither a letter nor a digit then it will return false
			if ((Character.isLetterOrDigit(str.charAt(i)) == false) && str.charAt(i) != ' ') {
				return false;
			}
		}
		return true;

	}

	@Override
	public String toString() {
		return "Design [width=" + width + ", hieght=" + hieght + ", slogan=" + slogan + ", color=" + color
				+ ", complexity=" + complexity + "]";
	}

}
