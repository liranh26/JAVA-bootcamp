package bootcamp.designExe;

import java.util.Random;

public class BorrowableAndBuyable extends BorrowableBook implements Purchaseable{
	
	//fields
	private int price;
	
	//constructor
	public BorrowableAndBuyable(String title, Author author, int qauntity, Genre genre, int numBorrowDays, int price) {
		super(title, author, qauntity, genre, numBorrowDays);
		setPrice(price);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price > 0)
			this.price = price;
		else
			System.out.println("Price must be greater than 0!");
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
			break;
		case 3: 
			buy();
		}
		
	}

	@Override
	public void buy() {
		String msg = "Sorry, The book is not available now";
		if (this.getQuantity() > 0) {
			this.setQuantity(quantity - 1);
			msg = "Congrats! Enjoy the book, The price is: "+ getPrice();
		}
		System.out.println(msg);
		
	}
	
	@Override
	protected int getAction() {
		Random action = new Random();
		return action.nextInt(4);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ " and for sale!";
	}
	
	

}
