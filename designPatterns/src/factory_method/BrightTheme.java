package factory_method;

public class BrightTheme extends ThemeFactory{

	@Override
	public ThemeText createText() {
		return new DarkText();
	}

}
