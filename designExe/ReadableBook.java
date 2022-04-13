package bootcamp.designExe;

import java.util.Random;

public class ReadableBook extends Book {
	
	//constructor
	public ReadableBook(String title, Author author, int qauntity, Genre genre) {
		super(title, author, qauntity, genre);

	}

	//methods
	
	@Override
	public void approach() {
		int action = getAction();
		System.out.println(this);
		if(action == 0)
			read();
		else
			returnBook();
	}
	
	public void read() {
		String msg = "Sorry, The book is not available now";
		if (this.getQuantity() > 0) {
			this.setQuantity(quantity - 1);
			msg = "Enjoy reading the book";
		}
		System.out.println(msg);
	}

	public void returnBook() {
		System.out.println("Hope you enjoyed the book! see you soon!");
		this.setQuantity(quantity + 1);
	}
	
	protected int getAction() {
		Random action = new Random();
		return action.nextInt(2);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nThis book is availble for reading" ;
	}
	
	
	


}
