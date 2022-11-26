package assg1_B01261294 ;

import java.util.Scanner ;

public class ColorFinder {

	public static void main(String[] args) {
		
		System.out.println("Please enter a sentence: ") ;
		
		// Creates user input object
		Scanner keyboard = new Scanner(System.in) ;
		
		String userString = keyboard.nextLine() ;
		
		// Transforms user entry into all lower case
		userString = userString.toLowerCase() ;
		
		// Checks for additive properties
		if		(userString.indexOf("green") != -1 || 
				userString.indexOf("red") != -1 || 
				userString.indexOf("blue")!= -1){
			System.out.println("Additive Primary Color Found!");
		}
		
		// Checks for subtractive properties
		else if(userString.indexOf("magenta") != -1 || 
				userString.indexOf("yellow") != -1 || 
				userString.indexOf("cyan") != -1){
			System.out.println("Subtractive Primary Color Found!");
		}
	}

}
