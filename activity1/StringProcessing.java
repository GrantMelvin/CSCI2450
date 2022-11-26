package activity1;

import java.util.Scanner ; 

public class StringProcessing {

	public static void main(String[] args) {
		
		System.out.println("Please enter a string with at least two characters: ") ;

		Scanner keyboard = new Scanner(System.in) ; // Creates input object
		
		String userString = keyboard.nextLine() ; // Gathers input into variable
		
		
		// Output
		System.out.println("The first character of the string is: " + userString.charAt(0));

		System.out.println("The last character of the string is: " + userString.charAt(userString.length() - 1));

		System.out.println("The substring between the first and last character is: " + 
										userString.substring(1, userString.length() - 1));
		
	}

}
