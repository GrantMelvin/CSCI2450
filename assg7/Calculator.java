/*
 * @author Grant melvin
 * Class to manipulate and calculate infix expressions 
 * and translates them into their postfix form
 */
package assg7_melvinm19;

import java.util.* ;

public class Calculator {
	
	private String exp ;
	
	// Used to determine the importance of an operator in the precedence method
	private char[] operators = {'-', '+', '*', '/', '%'}; 
	
	// Calculator constructor used to create our calculator object
	// @param 	exp	   expression that we will set this calculators expression to
	public Calculator(String exp) {
		this.exp = exp ;
	}
	
	// Creates the base toString method for the calculators expression
	public String toString() {
		return this.exp ;
	}
	
	// Converts the infix expression handed to us by the user into a postfix expression
	// that we can calculate
	// @return true if the value is converted successfully
	// @return false if the value is not converted successfully
	private boolean convertPostfix() {
		Stack<Character> stack = new Stack<Character>();
		
		// Creates the strings we will use for manipulation
		String baseExpression = "" ;
		String expression = "" ;
		String digit = "" ;
		
		// Keeps track of if there was an unclosed or unopened parentheses in the statement
		boolean parenth = true ;
		
		// Puts a space between every digit and operator in the expression handed to us by the user
		for(int i = 0 ; i < this.exp.length() ; i++) {
			if(Character.isDigit(this.exp.charAt(i)))
				baseExpression = (baseExpression + this.exp.charAt(i)) ;
			else
				baseExpression = (baseExpression + " " + this.exp.charAt(i)) + " ";
		}
		
		// Sets our expression to this manipulated string we've created
		this.exp = baseExpression ;
		
		// Loops through the expression for every character there is inside of it
		for(int i = 0 ; i < this.exp.length() ; i++) {

			// Verifies that this character is a digit and proceedes to add onto the digit until we hit a whitespace
			for(int j = i ; j < this.exp.length() ; j++) {
				if(this.exp.charAt(j) != ' ') {
					if(!checkOp(this.exp.charAt(i))) {
						digit = digit + this.exp.charAt(j) ;
					}
				}
				// Breaks out of the loop for this specific digit if we come across a non-digit character
				else
					break ;
			}
			
			switch(this.exp.charAt(i)) {
				case '%': // Allows all operators to pass onto this case where it is pushed onto the stack after			 
				case '/': // we pop from the stack and add onto our expression that will be pushed out
				case '*':
				case '+':
				case '-': 
					if(stack.empty())
						stack.push(this.exp.charAt(i)) ;
					else
					{
						while(!stack.isEmpty() && 
								stack.peek() != '(' &&
								precedence(this.exp.charAt(i)) <= precedence(stack.peek())) {
								try {
									expression = expression + stack.pop() ;
								}catch(EmptyStackException e) {
									return false ;
								}
							}
						stack.push(this.exp.charAt(i)) ;
					}
						break ;
				case '(':												// Sets parentheses variable to false until we get a closing one
					stack.push(this.exp.charAt(i)) ;
					parenth = false ;
					break ;
				case ')':												// Pops from stack until we hit the opening parentheses and sets the boolean to true if it is found
					while(!stack.isEmpty() && stack.peek() != '(') {
						expression = expression + stack.pop() ;
					}
					try {
						if(stack.pop() == '(')
							parenth = true ;
						else
							return false ;
					}catch(EmptyStackException e) {
						return false ;
					}
					break ;
				default:
					expression = expression + digit + " "; // If it is not an operate it is just added to the expression
			}
			
			i = i + digit.length() ; // If we have a 2 digit number, we dont want to reevaluate the second character in that digit again
			
			digit = "" ; 			// Resets our digit variable
			
		}
		
		// Pops all of our operators back onto the stack
		while(!stack.isEmpty())
			expression = expression + stack.pop() ; 
			
		this.exp = expression ;
		
		return parenth ;
	}
	
	/*
	 * Retrieves the postfix notation from the convertPostfix function
	 * @throws IllegalStateException if there is an invalid expression used
	 * @return the infix notation in postfix form
	 */
	public String getPostfix() throws IllegalStateException {
		try {
			if(this.convertPostfix())
				return "The postfix form of the expression is: " + 
					this.exp.replaceAll("\\s\s\s\s", " ").replaceAll("\\s\s\s", " ").replaceAll("\\s\s", " ").trim() ; 
			else
				throw new IllegalStateException() ;
		}catch(IllegalStateException e) {
			return "ERROR: Invalid expression" ;
		}
	} 
	
	/*
	 * Evaluates the postfix notation expression
	 * @throws an IllegalStateException if there is an invalid expression used
	 * @return the integer that is the answer to the expression passed into it
	 */
	public int evaluate() throws IllegalStateException {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		// variables used to track what will be pushed and popped from the stack
		int pop1 = 0 ;
		int pop2 = 0 ;
		int total = 0 ;
		String digit = "" ;
		
		boolean isOperator ; // Boolean to check if we are looking at a digit or not
		
		for(int i = 0 ; i < this.exp.length(); i++) {
			
			isOperator = false ; 	// resets our operator value
			digit = "" ; 			// resets our digit value
			
			// Checks to see if we are dealing with an operator
			isOperator = checkOp(this.exp.charAt(i)) ;
			
			
			// If we aren't dealing with an operator then it has to be a digit
			// If its not an empty space we add the character to the digit string and move on
			if(!isOperator) {
				for(int j = i ; j < this.exp.length() ; j++) {
					if(this.exp.charAt(j) != ' ') {
						digit += (((this.exp.charAt(j)))) ;
						i++ ;
					}
					else {
						break ;
					}
				}
			}
			
			// Handles an operator by popping the two things it will operate on 
			// Pushes the total of the two operands and the operator
			if(isOperator){
				try {
					pop1 = stack.pop(); 
					pop2 = stack.pop(); 
				}catch(EmptyStackException e) {}
				
				// Calculates the expression and what should be pushed as the total
				total = calcOp(this.exp.charAt(i), pop1, pop2) ;
				
				stack.push(total) ;
				
				}
			else {
				// Pushes the number to the stack if it is valid
				if(!digit.equals("")) {
					try {
					stack.push(Integer.valueOf(digit)) ; 
					}catch(NumberFormatException e) {
					}
				}	
			}
		}
		
		// Checks to see if we worked on a valid expression
		// Cannot be used before the calculation because it will alter our result
		if(!this.convertPostfix())
			throw new IllegalStateException() ;
		
		return total ;
	} 
	
	/*
	 * Method used to determine an operators value
	 * Used in the convertPostfix method
	 * @param	c	the operator that we will be checking the importance of
	 * @return 0 if the operator is - or +
	 * @return 1 if the operator is * or /
	 * @return 2 if the operator is %
	 */
	private int precedence(char c) {
		
		int index = -1 ;
		
		for(int i = 0 ; i < operators.length ; i++)
			if(c == operators[i])
				index = i ;
		
		if(index == 0 || index == 1)
			return 0 ;
		else if(index == 2 || index == 3)
			return 1 ;
		else
			return 2 ;
	}
	
	/*
	 * Merthod to check if a character is any operator
	 * @param c		the character to check if it is an operator
	 * @return true if it is an operator
	 * @return fales if it is not an operator
	 */
	private boolean checkOp(char c) {
		for(int i = 0 ; i < operators.length ; i++) 
			if(c == operators[i]) 
				return true ;
		
		return false ;
	}
	
	/*
	 * Method to calculate an expression
	 * @param	c		the operator that we need to match
	 * @param	pop1	the first popped object used in calculations
	 * @param	pop2	the second popped object used in calculations
	 * @return the answer to the expression of the two operands and the operator
	 */
	private int calcOp(char c, int pop1, int pop2) {
		// Checks to see which operation to use on the two operands
		if(c == operators[4]) 		// % operator
			return pop2 % pop1 ;
		else if(c == operators[3]) // / operator
			return pop2 / pop1 ;
		else if(c == operators[2]) // * operator
			return pop2 * pop1 ;
		else if(c == operators[1]) // + operator
			return pop2 + pop1 ;
		else if(c == operators[0]) // - operator
			return pop2 - pop1 ;
		else
			return -1 ;  
	}
}
