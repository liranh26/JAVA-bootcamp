package factory_method;

public abstract class ThemeFactory {
	
	public void showTheme() {
		
		ThemeText themeText = createText();
		
		System.out.println(themeText.getText());
		
	}
	
	public abstract ThemeText createText();

	
}
