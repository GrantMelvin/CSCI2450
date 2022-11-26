package activity2;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		
		// Output for user
		System.out.println("Please enter the size of the triangle you'd like: ") ;
		
		// Creates input object
		Scanner keyboard = new Scanner(System.in);
				
		// Gathers input from user
		int userNum = keyboard.nextInt() ;
		
		// Prints the triangle!
		printTriangle(userNum) ;
	}
	
	public static void printLine(int numOfAsterisks)
	{
		// Creates the total number of asterisks in the current line
		for(int i = 0 ; i < numOfAsterisks ; i++) System.out.print("*") ; 

		// Moves the cursor to the next line
		System.out.print("\n") ;
	}
	
	public static void printTriangle(int longestLine)
	{
		// Prints the lines of the triangle before and including the peak of the triangle
		for(int i = 1 ; i <= longestLine ; i++)
		{
			printLine(i);
		}
		
		// Prints the lines after the peak of the triangle
		for(int i = longestLine - 1 ; i >= 0 ; i--)
		{
			printLine(i);
		}
	}

}
