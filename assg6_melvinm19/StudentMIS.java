/*
 * @Author Grant Melvin
 * Class to allow user functionality for the Student and StudentList classes
 */
package assg6_melvinm19;

import java.util.* ;
import java.io.* ;

public class StudentMIS {

	public static void main(String[] args) {
	
		// Variables used for collecting data from user and decision-making
		StudentList studentList = new StudentList();
		
		Scanner kbd = new Scanner(System.in) ;
		
		String userString ;
		
		studentList.loadData("assg6_data.txt") ;
		
		String addedID, addedName, addedStanding, addedMajor ;
		
		do {
			
			// Menu
			System.out.println("1. Display the roster") ;
			System.out.println("2. Search student by id") ;
			System.out.println("3. Add a new student") ;
			System.out.println("4. Remove a student") ;
			System.out.println("5. Search for students by major") ;
			System.out.println("6. Sort and save to file") ;
			System.out.println("7. Save to file") ;
			System.out.println("8. Exit") ;
			System.out.println() ;
			
			userString = kbd.nextLine() ;
			System.out.println() ;
			
			switch(userString) {
			case "1":  // Displays the roster
				studentList.displayRoster();
				System.out.println();
				break ;
			case "2": // Asks for a user ID and searches it if it exists
				System.out.println("Please enter a student ID: ") ;
				userString = kbd.nextLine() ;
				if(studentList.searchForStudent(userString) == null)
					System.out.println("ERROR: Cannot find Student\n") ;
				else
					System.out.println(studentList.searchForStudent(userString)) ;
				break ;
			case "3": // Asks for a user ID and adds student to list if the ID is not taken
				System.out.println("Please enter the new student ID: ") ;
				addedID = kbd.nextLine() ;
				
				if(studentList.searchForStudent(addedID) != null)
				{
					System.out.println("ERROR: Student ID already exists!\n");
					break ;
				}
		
				System.out.println("Please enter the new student name: ") ;
				addedName = kbd.nextLine() ;
				System.out.println("Please enter the new student standing: ") ;
				addedStanding = kbd.nextLine() ;
				System.out.println("Please enter the new student major: ") ;
				addedMajor = kbd.nextLine() ;
				
				if(studentList.addStudent(addedID, addedName, addedStanding, addedMajor))
					System.out.println("Student added!\n") ;

				break ;
			case "4": // Asks for a user ID and deletes student from list if it exists
				System.out.println("Please enter the ID of the student to delete: ") ;
				userString = kbd.nextLine() ;
				
				if(studentList.removeStudent(userString))
					System.out.println("Student removed!\n") ;
				
				break ;
			case "5": // Asks for a major to search and creates a list with those majors. Deletes the list afterwards
				System.out.println("Please enter the major to search: ") ;
				userString = kbd.nextLine() ;
				
				if(studentList.getStudentsByMajor(userString).size() == 0)
					System.out.println("ERROR: Students with the \""
							+ userString + "\" major not found!\n") ;

				else
				{
					for(int i = 0 ; i < studentList.getStudentsByMajor(userString).size() ; i++)
					{
						System.out.print(studentList.getStudentsByMajor(userString).get(i)) ;
					}
					
					System.out.println() ;
				}

				break ;
			case "6": // Sorts and saves main list to assg6_data.txt file
				studentList.Sort() ;
				studentList.Save() ;
				
				break ;
			case "7": // saves main list to assg6_data.txt file
				studentList.Save() ;
				
				break ;
			case "8": // Breaks out of loop and ends program after saving students if there has been changes made
				studentList.Save() ;
				System.out.println("Goodbye!") ;
				break ;
			}
		}while(!userString.equals("8")) ;

	}
}
