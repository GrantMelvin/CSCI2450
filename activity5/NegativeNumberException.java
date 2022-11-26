package activity5;

public class NegativeNumberException extends Exception{
	
	public NegativeNumberException() {
		System.out.println("ERROR: Number is not positive.") ;
	}
	
	public NegativeNumberException(String msg) {
		super(msg) ;
	}
}
