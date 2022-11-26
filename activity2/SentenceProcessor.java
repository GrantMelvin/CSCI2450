package activity2;

import java.util.Scanner ; 

public class SentenceProcessor {

	public static void main(String[] args) {
		
		// Output for user
		System.out.println("Please enter a sentence") ;
		
		// Creates input object
		Scanner keyboard = new Scanner(System.in);
		
		// Gathers input from user
		String userEntry = keyboard.nextLine() ;
		
		// Checks last character in user-given string
		// Applies correct output for the character being checked
		switch(userEntry.charAt(userEntry.length() - 1))
		{
		case '?':
			if(userEntry.length() % 2 == 0 ) // Checks to see if characters are even or odd
			{
				System.out.println("That's an even question.") ;
			}
			else
			{
				System.out.println("That's an odd question.") ;

			}
			break ;
			
		case '!':
			System.out.println("Wow!") ;
			break ;
			
		case ',':
			System.out.println("More to come!") ;
			break ;
			
		default:
			System.out.println("You always say, \"" + userEntry + "\"" ) ;
			break ;
		}

	}

}
