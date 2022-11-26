package activity1;

import java.util.Scanner ;

public class TemperatureConverter {

	public static void main(String[] args) {
		
		System.out.println("Please enter a number to convert to celsius: ");
		
		Scanner numInput = new Scanner(System.in) ; // Creates the object of the input
		
		int userNum = numInput.nextInt() ; // Gathers the input into the variable 
		
		// Calculations and output
		double celsiusNum = (double)(userNum - 32) * 5 / 9 ;
		
		System.out.println("The converted temperature is: " + celsiusNum) ;

	}

}
