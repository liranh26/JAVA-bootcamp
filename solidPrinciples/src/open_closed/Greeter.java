package open_closed;

public class Greeter {
    Formality formality;

    Greeter(Formality formality){
    	this.formality = formality;
    }
    
    public String greet() {
    	return formality.greet();
    }

    public void setFormality(Formality formality) {
        this.formality = formality;
    }
}
