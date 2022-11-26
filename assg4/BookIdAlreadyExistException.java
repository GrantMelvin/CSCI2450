/*
 * @author Grant Melvin
 * Creates exception for duplicate bookIds
 */
package assg4_melvinm19;

@SuppressWarnings("serial")
public class BookIdAlreadyExistException extends RuntimeException{
	public BookIdAlreadyExistException() {
		super("Book ID already exists") ;
	}
	
	public BookIdAlreadyExistException(String msg) {
		super(msg) ;
	}
}
