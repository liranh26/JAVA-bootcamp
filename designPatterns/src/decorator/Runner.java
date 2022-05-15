package decorator;

public class Runner {

	public static void main(String[] args) {
		
		System.out.println("------------------");
		Dress dress = new BasicDress("Orange", 'M');
		dress.create();
		System.out.println("------------------");
//		
//		Dress dressCasual = new CasualDress(dress);
//		dressCasual.create();
//		System.out.println("------------------");
//		
//		Dress dressFancy = new FancyDress(dress);
//		dressFancy.create();
//		
		System.out.println("------------------");
		Dress fancyCasuality = new CasualDress( 
								new FancyDress(dress));
		fancyCasuality.create();
		System.out.println("------------------");
		Dress allTypes = new SportDress(
							new CasualDress( 
								new FancyDress(dress)));
		allTypes.create();
		System.out.println("------------------");
	}

}
