package bootcamp.designExe;

import java.util.Random;

//import java.time.LocalTime;
//import java.time.temporal.ChronoUnit;

public class BorrowableBook extends ReadableBook implements Borrowable{
	
	//fields 
	private int numBorrowDays;
	
	//constructor
	public BorrowableBook(String title, Author author, int qauntity, Genre genre, int numBorrowDays) {
		super(title, author, qauntity, genre);
		setNumBorrowDays(numBorrowDays);
	}
	
	public int getNumBorrowDays() {
		return numBorrowDays;
	}

	private void setNumBorrowDays(int numBorrowDays) {
		if(numBorrowDays>0)
			this.numBorrowDays = numBorrowDays;
		else
			System.out.println("The number of days must be greater then 0!");
	}

	
	@Override
	public void approach() {
		int action = getAction();
		System.out.println(this);
		switch(action) {
		case 0:
			this.read();
			break;
		case 1:
			borrowBook();
			break;
		case 2:
			returnBook();
		}
	
	}
	
	
	@Override
	public void borrowBook() {
		String msg = "Sorry, The book is not available now";
		if (this.getQuantity() > 0) {
			this.setQuantity(quantity - 1);
			msg = "Enjoy the book, the number of days dor borrowing is: "+ getNumBorrowDays();
		}
		System.out.println(msg);
		
	}
	
	@Override
	protected int getAction() {
		Random action = new Random();
		return action.nextInt(3);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" and borrowing";
	}
	
	

	
	
}
