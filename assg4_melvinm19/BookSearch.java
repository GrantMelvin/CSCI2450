/*
 * @author Grant Melvin
 * Output the files given 
 * Create book objects
 * Gather user input for search inquiries
 */

package assg4_melvinm19;

import java.util.* ;
import java.io.* ;

public class BookSearch {

	public static void main(String[] args){
		
		// Variable that determines how big to make the book array
		final int BOOKSARRAYSIZE = 6 ;
		
		// Creates the connection needed to the text file
		String filename = "assg4_catalog.txt" ;
		Scanner inputStream = null;	
		
		// Creates the array where the book objects will be stored
		// Uses the constant defined
		Book books[] = new Book[BOOKSARRAYSIZE];
		int bookCounter = 0 ;
		char charHolder = ' ' ;
		
		// Creates an array of strings to hold each individual piece of information
		// that a line gives
		String currentBookContent[] = new String[4] ;
		int contentCounter = 0 ;
		boolean checkToPrint = true ;
		
		// Variable used for customers inquiry
		String userEntry = null ;
		Scanner kbd = new Scanner(System.in) ;
		
		try {
			inputStream = new Scanner(new File(filename));	// Establishes a connection that can be parsed
			
			// Continues while we are not at the end of the file
			while (inputStream.hasNextLine()) {
				
				// Sets the current book content to what is being evaluated from the file
				currentBookContent[contentCounter] = inputStream.next() ;
				contentCounter++ ;
				
				// Checks to see if we are at the character portion of the file
				if(contentCounter == 4)
				{
					// Checks to see if the book is fiction or non-fiction
					if(inputStream.next().equals("N"))
						charHolder = 'N' ;
					else
						charHolder = 'F' ;
					
					// resets our variable used to parse through the array back to 0 
					contentCounter = 0 ;
					
					// Creates a new book
					books[bookCounter] = new Book(currentBookContent[0], currentBookContent[1],
							currentBookContent[2], currentBookContent[3], charHolder) ;
					
					// Checks to see if current bookId has been used before
					// Throws an error if it has been
					// Otherwise prints book
					checkDuplicate(books, currentBookContent, bookCounter, checkToPrint) ;
					
					// Resets values for next book
					checkToPrint = true ;
					bookCounter++ ;
				}
			}
			
			// Displays current number of books
			System.out.println("\nThere are " + bookCounter + " books in the current catalog.") ;
			
			System.out.println("Please enter a Book ID to print the information of that book: \n"
								+ "(Enter \"STOP\" to stop)") ;
			userEntry = kbd.nextLine() ;
			
			// Continues as lonmg as the user does not enter STOP
			while(!userEntry.equals("STOP")) {
				
				try {
					System.out.println(books[Book.bookSearch(books, bookCounter, userEntry)]) ;
				}catch(BookNotFoundException e) {
					System.out.println("ERROR: Book not found") ;
				}
				
				userEntry = kbd.nextLine() ;
			}
			
			inputStream.close();
			
		}catch(FileNotFoundException e) {					// Catches an error if the file cant be found
			System.out.println("Error: Cant find file");	
			System.exit(1);
		}
	}
	
	/*
	 * Prints the list of books for debugging purposes
	 * @param	books		array of books to traverse through
	 * @param	bookCounter	total number of books in the array
	 */
	public static void printBooks(Book books[], int bookCounter) {
		for(int i = 0 ; i < bookCounter ; i++)
		{
			System.out.println(books[i]);
		}
	}
	
	// Checks to see if the book has the same ID as a previous one and prints it if it does not
	/*
	 * @param	books				array of books to traverse through
	 * @param 	currentBookContent	the array that holds the bookId we need to evaluate
	 * @param	bookCounter			total number of books in the array
	 */
	public static void checkDuplicate(Book books[], String currentBookContent[], int bookCounter, 
			boolean checkToPrint) throws BookIdAlreadyExistException{
		
		// Traverses book array backwards and compares current book to all previous ones
		for(int i = bookCounter - 1 ; i >= 0 ; i--)
		{
			try {
				if(books[i].getBookId().equals(currentBookContent[0])) {	
					checkToPrint = false ;
					throw new BookIdAlreadyExistException() ;
				}
			}catch(BookIdAlreadyExistException e) {
				System.out.println("ERROR: Book ID already exists") ;
			}
		}
		
		// Prints book if its not a copy
		if(checkToPrint == true)
			System.out.println(books[bookCounter]);
	}
}
