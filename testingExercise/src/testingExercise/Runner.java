package testingExercise;

/**
*@author Liran Hadad
*/
public class Runner {

	public static void main(String[] args) {
		
		Tshirt[] tshirts = new Tshirt[3];
		
		Design design1 =  new Design(22.5, 17.2, "LESS is MORE", new Color((short)12,(short)13,(short)255));
		Design design2 =  new Design(26.8, 21.7, "HAKONA MATATA", new Color((short)156,(short)176,(short)35));
		
		tshirts[0] = new Tshirt();
		tshirts[1] = new Tshirt(design1, 0.5, 15, ShirtSize.S);
		tshirts[2] = new Tshirt(design2, 0.7, 20, ShirtSize.XL);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(tshirts[i]);
			System.out.println("Total price is: "+ tshirts[i].calculateFinalPrice()+". Is it expensive ? " + tshirts[i].isExpensive());
		}
		
	}
}
