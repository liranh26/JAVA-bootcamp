package testingExercise;

/**
 * @author Liran Hadad
 */
public class Tshirt {

	private static final double MIN_DEM_FACTOR = 0.1;
	private static final double MAX_DEM_FACTOR = 1;
	private static final double MIN_BASE_PRICE = 3;
	protected Design design;
	protected double demenadFactor;
	protected double basePrice;
	protected ShirtSize size;
	protected static final double EXPENSIZE_PRICE = 10000;

	public Tshirt() {
		this(new Design(), MIN_DEM_FACTOR, MIN_BASE_PRICE, ShirtSize.M);
	}

	public Tshirt(Design design, double demenadFactor, double basePrice, ShirtSize size) {
		setDesign(design);
		setDemenadFactor(demenadFactor);
		setBasePrice(basePrice);
		this.size = size;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public void setDemenadFactor(double demenadFactor) {
		if (demenadFactor >= MIN_DEM_FACTOR && demenadFactor <= MAX_DEM_FACTOR)
			this.demenadFactor = demenadFactor;
		else
			this.demenadFactor = MIN_DEM_FACTOR;
	}

	public void setBasePrice(double basePrice) {
		if (basePrice > 3)
			this.basePrice = basePrice;
		else
			this.basePrice = MIN_BASE_PRICE;
	}

	protected double calculateFinalPrice() {
		return (basePrice + design.complexity) * design.calcuteArea() / demenadFactor;
	}

	protected boolean isExpensive() {
		return calculateFinalPrice() >= EXPENSIZE_PRICE;
	}

	@Override
	public String toString() {
		return "Tshirt [design=" + design + ", demenadFactor=" + demenadFactor + ", basePrice=" + basePrice + ", size="
				+ size + "]";
	}



}
