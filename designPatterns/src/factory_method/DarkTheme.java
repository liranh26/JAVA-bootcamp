package factory_method;

public class DarkTheme extends ThemeFactory {

	@Override
	public ThemeText createText() {
		return new BrightText();
	}

}
