/*
 * @author Grant melvin
 * Class used to test and demonstrate the Calculator class
 */
package assg7_melvinm19;

import java.util.* ;

public class CalculatorDemo {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner kbd = new Scanner(System.in) ;
		char userChoice ;
		
		// Allows user to enter as many expressions as they'd like
		do {
			System.out.println("Please enter an infix expression to calculate the postfix expression and answer: ") ;
			Calculator exp = new Calculator(kbd.nextLine()) ;
			
		// tries to get the postfix form of the user entered expression
		// catches the invalid expression exception we have being thrown from the getPostfix class
		try {
			System.out.println(exp.getPostfix()) ;
		}catch(IllegalStateException e){} 
		
		// tries to get the answer to from the postfix expression gathered from the user string
		// catches the invalid expression exception we have being thrown from the getPostfix class
		try {
			System.out.println("The answer to the expression is: " + exp.evaluate()) ;
		}catch(IllegalStateException e) {} 
		
		System.out.println("Continue? (Y/N)") ;
		
		userChoice = kbd.nextLine().charAt(0) ;
		
		}while(userChoice == 'Y' || userChoice == 'y') ;
		
		System.out.println("Goodbye!") ;	
	}
}
