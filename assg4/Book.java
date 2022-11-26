/*
 * @author Grant Melvin
 * Creates book object contructors
 * Creates get methods for each instance variable of book
 * Creates methods used for the books array
 */
package assg4_melvinm19;

public class Book {

	// Instance variables used for the book object
	private String bookId ;
	
	private String title ;
	
	private String isbn ;
	
	private String author ;
	
	private char category ;
	
	/*
	 * Only constructor used to make book objects
	 * @param	bookId		book ID that is passed to the new book object
	 * @param	title		title that is passed to the new book object
	 * @param	isbn		isbn that is passed to the new book object
	 * @param 	author		author that is passed to the new book object
	 * @param	category	category that is passed to the new book object
	 */
	public Book(String bookId, String title, String isbn, String author, char category) {
		this.bookId = bookId ;
		this.title = title ;
		this.isbn = isbn ;
		this.author = author ;
		this.category = category ;
	}
	
	/*
	 * retrieves the book ID from the book its called on
	 * @return bookId value of selected book
	 */
	public String getBookId() {
		return this.bookId ;
	}
	
	/*
	 * retrieves the title from the book its called on
	 * @return title value of selected book
	 */
	public String getTitle() {
		return this.title ;
	}
	
	/*
	 * retrieves the isbn from the book its called on
	 * @return isbn value of selected book
	 */
	public String getISBN() {
		return this.isbn ;
	}
	
	/*
	 * retrieves the author from the book its called on
	 * @return author value of selected book
	 */
	public String getAuthor() {
		return this.author ;
	}
	
	/*
	 * retrieves the category from the book its called on
	 * @return category value of selected book
	 */
	public char getCategory() {
		return this.category ;
	}
	
	/*
	 * Displays the information about the selected book to the screen
	 * @return a string holding book properties
	 */
	public String toString() {
		return getBookId() + " " + getTitle() + " " + getISBN() + " " + getAuthor() + " " + getCategory() ;
	}
	
	/*
	 * Searches the book array to see if we can find the bookId that the user passed through
	 * @param	books		array of books we need to parse through
	 * @param	numOfBooks	number of book objects that are actually in the array
	 * @param	userEntry	the bookId we are looking for in the array
	 * @throw BookNotFoundException if we can't find the desired bookId from the user
	 */
	public static int bookSearch(Book books[], int numOfBooks, String userEntry) {
		for(int i = 0 ; i < numOfBooks ; i++) {
			if(books[i].bookId.equals(userEntry))
				return i ;
			}
	throw new BookNotFoundException() ;
	}

}
