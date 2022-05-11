package factory_method;

public class BrightText implements ThemeText{
	String text;
	
	
	public BrightText() {
		
		text = ("~~ Bright text & Dark Background ~~");
	}
	
	@Override
	public String getText() {
		return text;
	}

}
