package bootcamp.designExe;

public abstract class Book implements Readable{
	
	//fields
	protected String title;
	protected Author author;
	protected int quantity;
	public final Genre genre;

	
	enum Genre{
		COOKING, DICIONARY, NOVEL; 
	}
	
	//constructor
	public Book(String title, Author author, int qauntity, Genre genre) {
		this.author = new Author(author.getName(), author.getGender());
		setTitle(title);
		setQuantity(qauntity);
		this.genre = genre; 
	}
	
	//setters & getters
	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	protected void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	//methods
	public abstract void approach();

	public abstract void returnBook();

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The book name "+title+" ,"+" the genre of the book is "+genre+"\nThe author name is: "+author.getName()+ " number of books availbe is "+quantity;
	}
	
	

}
