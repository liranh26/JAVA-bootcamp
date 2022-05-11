package bootcamp.oop.lessonExe2Runner;

public class Runner {

	public static void main(String[] args) {
		// Default Complex Number 0+0i
		ComplexNum c0 = new ComplexNum();
		c0.printComplexNum();
		// 5+6i
		ComplexNum c1 = new ComplexNum(4, -3);
		c1.printComplexNum();
		// 6-9i
		ComplexNum c2 = new ComplexNum(2, 2);
		c2.printComplexNum();
		double c9 = c1.mag();
		System.out.println(c9);
		c1.printComplexNum();
		ComplexNum c1_plus_c2 = ComplexNum.add(c1,c2);
		ComplexNum c1_minus_c2 = ComplexNum.subtract(c1, c2);
		ComplexNum c1_into_c2 = ComplexNum.multiply(c1, c2);
//		ComplexNum c1_by_c2 = ComplexNum.divide(c1, c2);
//
//		System.out.println(c1.toString() + " + " + c2.toString() + " = " + c1_plus_c2.toString());
//		System.out.println(c1.toString() + " - " + c2.toString() + " = " + c1_minus_c2.toString());
//		System.out.println(c1.toString() + " * " + c2.toString() + " = " + c1_into_c2.toString());
//		System.out.println(c1.toString() + " / " + c2.toString() + " = " + c1_by_c2.toString());
//
//		// Parsing Complex Numbers
//		ComplexNum c3 = ComplexNum.parseComplex("-4+7i");
//		System.out.println(c3.toString());
//
//		// Magnitude
//		System.out.println(c3.mag());
//
//		// Conjugate
//		System.out.println(c3.conjugate());
	}

}
