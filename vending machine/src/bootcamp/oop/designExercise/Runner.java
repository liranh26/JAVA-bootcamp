package bootcamp.oop.designExercise;

import java.util.Scanner;

/**
 * This is a Vending Machine program, it have cold and hot drinks according a
 * menu.
 * 
 * @author Liran Hadad
 *
 */
public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (VendingMachine.isFull) {
			showMenu();
			int opt = Integer.parseInt(sc.next());
			Produceable drink = createDrink(opt);
			if (opt == 0)
				break;
			drink.produce();
		}
	}

	private static Produceable createDrink(int opt) {
		switch (opt) {
		case 0:
			System.out.println("Good Bye!");
			break;
		case 1:
			return new Chocolate();
		case 2:
			return new Espresso();
		case 3:
			return new Cappuccino();
		case 4:
			return new Latte();
		case 5:
			return new Cola();
		case 6:
			return new Sprite();
		case 7:
			return new OrangeJuice();
		case 8:
			return new AppleJuice();
		}
		return null;

	}

	public static void showMenu() {
		System.out.println("Please select a drink or enter 0 to exit:");
		System.out.println("1. Hot Chocolate\n" + "2. Hot Espresso\n" + "3. Hot Cappuccino\n" + "4. Hot Latte\n"
				+ "5. Cola\n" + "6. Sprite\n" + "7. Orange Juice\n" + "8. Apple Juice");
	}

}
