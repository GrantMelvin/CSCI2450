package activity9;
import java.util.* ;

public class StackPractice {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in) ;
		
		System.out.println("Please enter a string: ") ;
		
		String userString = kbd.nextLine() ;
		
		System.out.println("Testing the stack reverse method: ") ;
		System.out.println(strRevStack(userString)) ;

		
		System.out.println("Testing the loop reverse method: ") ;
		System.out.println(strRevIterative(userString)) ;
		
		
		System.out.println("Testing the recursive reverse method: ") ;
		System.out.println(strRevRecursive(userString));

		

	}
	
	
	public static String strRevStack(String st) {
		
	   Stack<Character> charStack = new Stack<Character>();
	   char[] charArray = new char[100] ;
	   int counter = 0 ;
	   
	   while(counter < st.length())
	   {
		   charStack.push(st.charAt(counter)) ;
		   counter++ ;
	   }
	   
	   counter = 0 ;
	   
	   while(!charStack.empty())
	   {
		   charArray[counter] = charStack.pop() ;
		   counter++ ;
	   }
	   
	   return new String(charArray);
		
	}
	
	public static String strRevIterative(String st) {
		
		char[] charArray = new char[100] ;
		int counter = 0 ;
		
		for(int i = st.length() - 1 ; i >= 0 ; i--)
		{
			charArray[counter] = st.charAt(i);
			counter++ ;
		}
		
		return new String(charArray);
		
	}

	public static String strRevRecursive(String st) {
	
	if(st == null || !(st.length() >= 1))
	{
		return st ;
	}
	
	return strRevRecursive(st.substring(1)) + st.charAt(0) ;
	
	}

}
