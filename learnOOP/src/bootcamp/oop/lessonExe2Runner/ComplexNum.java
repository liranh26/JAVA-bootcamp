package bootcamp.oop.lessonExe2Runner;

public class ComplexNum implements Complexable{
	
	//fields
	private double real;
	private double img;
	
	public ComplexNum(double real, double img) {
		this.real = real;
		this.img = img;
	}
	
	//constructors
	public ComplexNum() {
		this(0, 0);
	}
	
	//getters setters
		private void setReal(double real) {
		this.real = real;
	}

	private void setImg(double img) {
		this.img = img;
	}
	
	public double getReal() {
		return this.real;
	}
	
	public double getImg() {
		return this.img;
	}
	

	//methods
	

	public void printComplexNum() {
		String imgSign = "+";
		if(this.img<0)
			imgSign = "";
		String numStr = this.real + imgSign + this.img + "i";
		System.out.println(numStr);
	}
	
	@Override
	public void add(ComplexNum z) {
		setReal(this.real + z.real);
		setImg(this.img + z.img);
	}


	@Override
	public void subtract(ComplexNum z) {
		setReal(this.real - z.real);
		setImg(this.img - z.img);
		
	}

	@Override
	public void multiply(ComplexNum z) {
		double realRes = this.real*z.getReal() - this.img*z.getImg();
		double imgRes = this.real*z.getImg() + this.img*z.getReal();
		setReal(realRes);
		setImg(imgRes);
	}

	@Override
	public void divide(ComplexNum z) { ///////////////////////////////////////////////////////////////
		z.setImg(z.getReal()*-1); //the zamod
		this.multiply(z);
		this.setImg(this.img/Math.pow(z.getImg(), 2));
		this.setReal(this.real/Math.pow(z.getReal(), 2));
	}

	@Override 
	public ComplexNum conjugate() {
		return new ComplexNum(this.real, this.img*-1);
	}

	@Override
	public double mag() {
		return this.img*this.img + this.real*this.real;
	}

	@Override
	public ComplexNum square() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplexNum pow(ComplexNum z, int power) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplexNum inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Adds two ComplexNum.
	 * 
	 * @param z1 the first ComplexNum.
	 * @param z2 the second ComplexNum.
	 * @return the resultant ComplexNum (z1 + z2).
	 */
	public static ComplexNum add(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = new ComplexNum();
		result.setImg(z1.getImg()+z2.getImg());
		result.setReal(z1.getReal() + z2.getReal());
		return result;
	}

	/**
	 * Subtracts one ComplexNum from another.
	 * 
	 * @param z1 the first ComplexNum.
	 * @param z2 the second ComplexNum.
	 * @return the resultant ComplexNum (z1 - z2).
	 */
	public static ComplexNum subtract(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = new ComplexNum();
		result.setImg(z1.getImg() - z2.getImg());
		result.setReal(z1.getReal() - z2.getReal());
		return result;
	}

	/**
	 * Multiplies one ComplexNum to another.
	 * 
	 * @param z1 the first ComplexNum.
	 * @param z2 the second ComplexNum.
	 * @return the resultant ComplexNum (z1 * z2).
	 */
	public static ComplexNum multiply(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = new ComplexNum();
		
		double realRes = z1.getReal()*z2.getReal() - z1.getImg()*z2.getImg();
		double imgRes = z1.getReal()*z2.getImg() + z1.getImg()*z2.getReal();
		result.setReal(realRes);
		result.setImg(imgRes);
		
		return result;
	}

	/**
	 * Divides one ComplexNum by another.
	 * 
	 * @param z1 the first ComplexNum.
	 * @param z2 the second ComplexNum.
	 * @return the resultant ComplexNum (z1 / z2).
	 */
	public static ComplexNum divide(ComplexNum z1, ComplexNum z2) {
		ComplexNum result = new ComplexNum();
		result.add(z1);
		result.multiply(z2);
		
		return null;
	}

	/**
	 * Parses the String as a ComplexNum of type x+yi.
	 * 
	 * @param s the input complex number as string
	 * @return a ComplexNum which is represented by the string.
	 */
	public static ComplexNum parseComplex(String s) {
		return null;
	}
	
}
