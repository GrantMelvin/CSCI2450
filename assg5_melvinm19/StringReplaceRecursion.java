package assg5_melvinm19;

import java.util.* ;

public class StringReplaceRecursion {

	public static void main(String[] args) {
		
	Scanner kbd = new Scanner(System.in);

	System.out.println("1. Test replace method") ;
	System.out.println("1. Test replaceAll method") ;
	System.out.println("3. Exit") ;
	
	int userChoice = kbd.nextInt() ;
	
	String userString = null ; 
	char userOldChar ;
	char userNewChar ;
	
	String newMessage = null ;
	
	while(userChoice != 3) {
		
		switch(userChoice) {
		case 1: 
			
			// Gets all variables for replace method from user
			System.out.println("Please enter a String: ") ;
			userString = kbd.next() ;
			
			System.out.println("Please enter an old character: ") ;
			userOldChar = kbd.next().charAt(0) ;
			System.out.println("Please enter a new character: ") ;
			userNewChar = kbd.next().charAt(0) ; ;
			
			// Calls replace function with correct parameters
			newMessage = replace(userString, userOldChar, userNewChar) ;
			System.out.println("The new message is: " + newMessage) ;
			
			break ; 
		case 2: 
			
			// Gets all variables for replace method from user
			System.out.println("Please enter a String: ") ;
			userString = kbd.next() ;
			
			System.out.println("Please enter an old character: ") ;
			userOldChar = kbd.next().charAt(0) ;
			System.out.println("Please enter a new character: ") ;
			userNewChar = kbd.next().charAt(0) ; ;
			
			// Calls replace function with correct parameters
			newMessage = replaceAll(userString, userOldChar, userNewChar) ;
			System.out.println("The new message is: " + newMessage) ;
			
			break ;
		}
		
		userChoice = kbd.nextInt() ;
	}
	
	kbd.close() ;

}

	public static String replace(String st, char oldChar, char newChar) {
		
		// BASE CASE: We have an old character and need to replace with the new
		if(st.charAt(0) == oldChar)
		{
			return newChar + st.substring(1) ;
		}
		
		// RECURSIVE CASE: We do not have an old character and need to evaluate the next character
		else
		{
			return st.charAt(0) + replace(st.substring(1), oldChar, newChar) ;
		}
	}
	
	public static String replaceAll(String st, char oldChar, char newChar) {
		
		// BASE CASE: We have an old character and need to replace with the new
		if(st.charAt(0) == oldChar)
		{
			return newChar + st.substring(1) ;
		}
				
		// RECURSIVE CASE: We do not have an old character and need to evaluate the next character
		else
		{
			return replaceAll(st.substring(1), oldChar, newChar) ;
		}
	}
	
}
