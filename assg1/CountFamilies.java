/*
 * @author: Grant Melvin 
 * Class: CSCI 2540
 * Date: 08/26/2022
 */

package assg1_B01261294;

import java.util.* ;

public class CountFamilies {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in) ; // Creates the input object
		int maxIncome = 0 ; 						// Initializes maximum income
		boolean output = false ; 					// Determines if part of the menu output should be used
		int lowIncomeCounter = 0 ; 					// Keeps track of the number of families under 10% of max
		
		// input / Output for user
		System.out.print("Please enter the number of families: ");
		int numOfFamilies = keyboard.nextInt() ;
		
		// Sets the size of array to user-requested number
		int familiesArray[] ;
		familiesArray = new int[numOfFamilies] ;
		
		// Gets numbers from user and adjusts max
		for(int i = 0 ; i < numOfFamilies ; i++)
		{
			System.out.print("Enter an income: ") ;
			familiesArray[i] = keyboard.nextInt() ;
			
			if(familiesArray[i] > maxIncome)
			{
				maxIncome = familiesArray[i] ; 
			}
		}
		
		// Finds out if there are low income families in the array
		for(int i = 0 ; i < numOfFamilies ; i++)
		{
			if(familiesArray[i] < maxIncome*.10)
			{
				output = true ;
			}
		}
			
		// Final output
		System.out.println("The maximum income is: " + maxIncome);
		
		// Checks if there are families making less than 10% of the max income
		// If there are families under 10% of max income, it prints those families and adds to the low income family tracker
		if(output == true)
		{
			System.out.println("The incomes of families making less than 10% of the "
					+ "maximum income are: ") ;
			for(int i = 0 ; i < numOfFamilies ; i++)
			{
				if(familiesArray[i] < maxIncome*.10)
				{     
					System.out.println(familiesArray[i]);
					lowIncomeCounter++ ;
				}
			}
			System.out.println("For a total of " + lowIncomeCounter + " families");
		}
	}
}
