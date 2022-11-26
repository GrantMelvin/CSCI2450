package activity3;

public class SpecialTopicCourseTest {

	public static void main(String[] args) {
		SpecialTopicCourse c1 = new SpecialTopicCourse("2540", "Object-Oriented Programming", "CSCI") ;
		SpecialTopicCourse c2 = new SpecialTopicCourse("2410", "Digital Logic Design", 6, "ENG") ;
		
		Course c3 = new SpecialTopicCourse("2100", "Calculus", "MATH") ;
		
		System.out.println("Before changing topics:");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println();

		System.out.println("After changing topics:");
		
		c1.setTopic("Computer Science");
		
		System.out.println("c1's new topic: " + c1.getTopic());
		
		System.out.println();

		System.out.println("Using toString to print:");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println();
		
		System.out.println("Using the printInfo method:");
		
		c1.printInfo();
		c2.printInfo();
		c3.printInfo();
		
		System.out.println();
		
		System.out.println("Is c1 equal to c2?");
		if(c1.equals(c2))
			System.out.println("Yes");
		else
			System.out.println("No");
		
		System.out.println("Is c1 equal to c3?");
		if(c1.equals(c3))
			System.out.println("Yes");
		else
			System.out.println("No");
		
		System.out.println("Is c1 equal to c1?");
		if(c1.equals(c1))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
