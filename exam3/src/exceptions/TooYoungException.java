package exceptions;

public class TooYoungException extends RuntimeException {

	private static final long serialVersionUID = 4597371658834548420L;
	
	private String message;
	
	public TooYoungException() {
		super();
		setMessage("The is greater then 8/8/888");
	}

	private void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
