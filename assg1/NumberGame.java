/* @author: Grant Melvin
 * Class: CSCI 2540
 * Date: 08/26/2022
 */

package assg1_B01261294;

import java.util.* ;

public class NumberGame {

	public static void main(String[] args) {
		int secret ; 						// Holds the value the user is trying to find
		int userNum = 100 ; 				// Holds the number that the user enters
		int counter = 0 ; 					// Keeps track of how many tries it takes the user
		
		// Creates the random number object and the input object
		Random generator = new Random(); 
		Scanner keyboard = new Scanner(System.in) ;
		
		// Generates the secret number
		secret = generator.nextInt(100); 
		//System.out.println(secret); // Used for debugging
		
		System.out.println("Please guess the secret number!");
		
		// Gathers input from user and increases tries
		userNum = keyboard.nextInt(); 
		counter++ ;
		
		// Loops as long as the user doesn't guess the correct number
		while(userNum != secret)
		{
			// Checks to see if the guess was less than the secret
			// Increases counter of user tries
			// Gathers next input
			if(userNum < secret)
			{
				System.out.println("Your guess was less than the secret number") ;
				System.out.println("Please try to guess again") ;
				counter++ ;
				userNum = keyboard.nextInt(); 
			}
			
			// Checks to see if the guess was greater than the secret
			// Increases counter of user tries
			// Gathers next input
			else if(userNum > secret)
			{
				System.out.println("Your guess was greater than the secret number") ;
				System.out.println("Please try to guess again") ;
				counter++ ;
				userNum = keyboard.nextInt(); 
			}
		}
		
		// Occurs when the secret has been found 
		System.out.println("You've guessed the correct number!") ;
		System.out.println("It took you " + counter + " tries to guess the correct number") ;

	}

}
