/*
 * Class to test the Course class
 * @author Grant Melvin
 */

package activity3;

public class CourseTest {

	public static void main(String[] args) {
		
		// Constructs two basic test classes
		Course c1 = new Course("2540", "Object Programming") ;
		
		Course c2 = new Course("2410", "Logic", 3) ;
		
		// Uses the toString methods to print courses
		System.out.println(c1) ;
		
		System.out.println(c2) ;
		
		// Uses the set methods to change the two courses
		c1.setTitle("Object-Oriented Programming") ;
		
		c1.setCredit(8) ;
		
		// Tells the user what has been changed using the set methods
		System.out.println("The name of 2540 has been changed to: " + c1.getTitle()) ;

		System.out.println("The credits of 2540 have been changed to: " + c1.getCredit() + "\n") ;
		
		// Uses printInfo method for the two courses
		c1.printInfo();
		
		c2.printInfo();

	}

}
