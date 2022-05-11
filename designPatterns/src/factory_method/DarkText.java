package factory_method;

public class DarkText implements ThemeText {

String text;

	public DarkText() {
		text = ("~~ Dark text & Bright Background ~~");
	}
	


	@Override
	public String getText() {
		return text;
	}


	
}
