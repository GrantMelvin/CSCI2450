/*
 * Class used to test methods of Point and Extendedcircle classes
 * @author Grant melvin
 * September 6, 2022
 */

package assg2_B01261294;

public class ExtendedCircleTest {

	public static void main(String[] args) {
		
		// Constructs 5 different points using all types of constructors
		Point p1 = new Point() ;
		Point p2 = new Point(2,3) ;
		Point p3 = new Point(5,7) ;
		Point p4 = new Point(4,-1) ;
		Point p5 = new Point(1,-5) ;
		Point p6 = new Point(1,0) ;
		
		// Constructs 5 different circles using all types of constructors
		ExtendedCircle c1 = new ExtendedCircle() ;
		ExtendedCircle c2 = new ExtendedCircle(2) ;
		ExtendedCircle c3 = new ExtendedCircle(4, p2) ;
		ExtendedCircle c4 = new ExtendedCircle(3, p1) ;
		ExtendedCircle c5 = new ExtendedCircle(50, p5) ;

		// Displays all points using the ToString and getX / getY methods
		System.out.println("Point 1 | (" + p1.getX() + "," + p1.getY() + ")") ;
		System.out.println("Point 2 | " + p2) ;
		System.out.println("Point 3 | (" + p3.getX() + "," + p3.getY() + ")") ;
		System.out.println("Point 4 | " + p4) ;
		System.out.println("Point 5 | (" + p5.getX() + "," + p5.getY() + ")") ;
		System.out.println("Point 6 | " + p6) ;
		
		System.out.println();
		
		// Uses the setX & setY values
		System.out.println("Setting Point 1 x-value to 5") ;
		p1.setX(5);
		
		System.out.println("Setting Point 1 y-value to 5") ;
		p1.setY(5);
		System.out.println("Point 1 is now: " + p1) ;
		
		
		System.out.println();
		
		// Displays the distance between certain points using the distance method
		System.out.printf("The distance between point 1 and 3 | %.3f\n" , p1.distance(p3));
		System.out.printf("The distance between point 2 and 4 | %.3f\n" , p2.distance(p4));
		System.out.printf("The distance between point 3 and 5 | %.3f\n" , p3.distance(p5));
		System.out.printf("The distance between point 4 and 6 | %.3f\n" , p4.distance(p6));
		System.out.printf("The distance between point 5 and 1 | %.3f\n" , p5.distance(p1));
		
		System.out.println();

		// Displays the equals property of certain points using the equals method
		System.out.print("Is point 1 equal to point 2? ") ;
		if(p1.equals(p2) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;	
		
		System.out.print("Is point 1 equal to point 1? ") ;
		if(p1.equals(p1) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;
		
		System.out.print("Is point 3 equal to point 5? ") ;
		if(p3.equals(p5) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;
		
		System.out.print("Is point 4 equal to point 4? ") ;
		if(p4.equals(p4) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;
		
		System.out.println();
		
		// Displays all of the circles using the toString and getRadius / getCenter methods
		System.out.println("Circle 1 | " + c1);
		System.out.println("Circle 2 | Radius: " + c2.getRadius() + ", Center: " + c2.getCenter());
		System.out.println("Circle 3 | " + c3);
		System.out.println("Circle 4 | Radius: " + c4.getRadius() + ", Center: " + c4.getCenter());
		System.out.println("Circle 5 | " + c5);
		
		System.out.println();
		
		// Displays all of the circles' area using the compArea method
		System.out.printf("Circle 1 area | %.3f\n" , c1.compArea());
		System.out.printf("Circle 2 area | %.3f\n" , c2.compArea());
		System.out.printf("Circle 3 area | %.3f\n" , c3.compArea());
		System.out.printf("Circle 4 area | %.3f\n" , c4.compArea());
		System.out.printf("Circle 5 area | %.3f\n" , c5.compArea());
		
		System.out.println();
		
		//Displays all of the circles' circumference using the compCircumference method
		System.out.printf("Circle 1 circumference | %.3f\n" , c1.compCircumference());
		System.out.printf("Circle 2 circumference | %.3f\n" , c2.compCircumference());
		System.out.printf("Circle 3 circumference | %.3f\n" , c3.compCircumference());
		System.out.printf("Circle 4 circumference | %.3f\n" , c4.compCircumference());
		System.out.printf("Circle 5 circumference | %.3f\n" , c5.compCircumference());
		
		System.out.println();
		
		// Displays the relationship between certain points and circles using the positionToCircle method
		System.out.print("Where is point 1 in relation to circle 3? ") ;
		if(c3.positionToCircle(p1) == -1)
			System.out.println("inside") ;
		else if(c3.positionToCircle(p1) == 0)
			System.out.println("on the edge") ;	
		else
			System.out.println("outside") ;	
		
		System.out.print("Where is point 4 in relation to circle 2? ") ;
		if(c2.positionToCircle(p4) == -1)
			System.out.println("inside") ;
		else if(c2.positionToCircle(p4) == 0)
			System.out.println("on the edge") ;	
		else
			System.out.println("outside") ;	
		
		System.out.print("Where is point 6 in relation to circle 1? ") ;
		if(c1.positionToCircle(p6) == -1)
			System.out.println("inside") ;
		else if(c1.positionToCircle(p6) == 0)
			System.out.println("on the edge") ;	
		else
			System.out.println("outside") ;	

		System.out.println() ;	
		
		// Displays the shifted values of certain circles' centers using the shift method
		System.out.print("The first circle shifted by (5,7) now has the values of: ") ;	
		System.out.println(c1.shift(5, 7)) ;
		
		System.out.print("The second circle shifted by (-5,7) now has the values of: ") ;	
		System.out.println(c2.shift(-5, 7)) ;
		
		System.out.print("The third circle shifted by (5-7) now has the values of: ") ;	
		System.out.println(c3.shift(5, -7)) ;
		
		System.out.print("The fourth circle shifted by (-5,-7) now has the values of: ") ;	
		System.out.println(c4.shift(-5, -7)) ;
		
		System.out.println() ;	
		
		// Displays the scaled values of certain circles' radius' using the shift method
		System.out.print("The first circle scaled by a factor of 2 now has the values of: ") ;	
		System.out.println(c1.scale(2)) ;
		
		System.out.print("The second circle scaled by a factor of .4 now has the values of: ") ;	
		System.out.println(c2.scale(.4)) ;
		
		System.out.print("The third circle scaled by a factor of 1.5 now has the values of: ") ;	
		System.out.println(c3.scale(1.5)) ;
		
		System.out.print("The fourth circle scaled by a factor of 8 now has the values of: ") ;	
		System.out.println(c4.scale(8)) ;

		System.out.println() ;	
		
		// Displays the overlap relationship between certain circles using the overlap method
		System.out.print("Is circle 1 overlapping with circle 1? ") ;
		if(c1.overlap(c1) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;	
		
		System.out.print("Is circle 4 overlapping with circle 1? ") ;
		if(c4.overlap(c1) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;	
		
		
		System.out.print("Is circle 2 overlapping with circle 4? ") ;
		if(c2.overlap(c4) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;	
		
		
		System.out.print("Is circle 5 overlapping with circle 2? ") ;
		if(c5.overlap(c2) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;	
		
		
		System.out.println();
		
		// Displays the equal property of certain circles using the equals method
		System.out.print("Is circle 1 equals to circle 2? ") ;
		if(c1.equals(c2) == true)
				System.out.println("yes") ;
		else
			System.out.println("no") ;	
		
		System.out.print("Is circle 1 equals to circle 1? ") ;
		if(c1.equals(c1) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;	
		
		System.out.print("Is circle 3 equals to circle 5? ") ;
		if(c3.equals(c5) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;	
		
		System.out.print("Is circle 4 circle to circle 4? ") ;
		if(c4.equals(c4) == true)
			System.out.println("yes") ;
		else
			System.out.println("no") ;	
		
		System.out.println();
		
	}
}
