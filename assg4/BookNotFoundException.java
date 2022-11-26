/*
 * @author Grant Melvin
 * Creates exception for when the bookId cannot be found
 */
package assg4_melvinm19;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException{
	public BookNotFoundException() {
		super("Book not found!") ;
	}
	
	public BookNotFoundException(String msg) {
		super(msg) ;
	}
}
