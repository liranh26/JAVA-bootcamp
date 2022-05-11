package factory_method;

public class Runner {

	private static ThemeFactory theme;
	
	public static void main(String[] args) {
		
		configure("Dark");
		runBusinessLogic();
	}
	
	private static void configure(String s) {
		if (s == "Dark") {
			theme = new DarkTheme();
		} else {
			theme = new BrightTheme();
		}
	}

	private static void runBusinessLogic() {
		theme.showTheme();
	}

}
