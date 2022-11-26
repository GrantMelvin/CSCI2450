package activity5;

import java.util.Scanner ;

public class ExceptionPractice {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in) ;
		int userNum ;

		System.out.print("Please enter a number to get the sqrt: ") ;
		
		userNum = kbd.nextInt() ;
		
		try {
			if(userNum < 0)
				throw new NegativeNumberException();
			else
				System.out.println("The square root of " + userNum + " is: " + Math.sqrt(userNum)) ;
		}catch(NegativeNumberException e) {
			System.exit(1) ;
		}

	}

}
