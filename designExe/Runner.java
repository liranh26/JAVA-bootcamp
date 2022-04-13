package bootcamp.designExe;

import bootcamp.designExe.Book.Genre;

public class Runner {

	public static void main(String[] args) {

		Author jk = new Author("JK roling", 'f');
		Author teacher = new Author("sapir", 'f');
		Author liran = new Author("liran", 'm');

		Book[] arr = new Book[6];
		
		arr[0] = new BorrowableAndBuyable("Morfix", jk, 5, Genre.DICIONARY, 10, 100);
		arr[1] = new BorrowableAndBuyable("Spanglish", teacher, 4, Genre.DICIONARY, 10, 50);
		arr[2] = new ReadableBook("Harry Potter", jk, 8, Genre.NOVEL);
		arr[3] = new BorrowableBook("Harry Azkaban!", jk, 6, Genre.NOVEL, 30);
		arr[4] = new BorrowableBook("Italian", liran, 3, Genre.COOKING, 14);
		arr[5] = new ReadableBook("Barbiquiu", jk, 5, Genre.COOKING);
		
		
		for (Book book : arr) {
			System.out.println("---------------------");
			book.approach();
		}
		
	}

}
