/*
 * @Author Grant Melvin
 * Class to create and use an arrayList of students to be used in the StudentMIS class
 */
package assg6_melvinm19;

import java.util.* ; 
import java.io.* ;

public class StudentList implements StudentListInterface {
	
	// the arrayLists for various groups of students used in the methods
	private ArrayList<Student> studentList = new ArrayList<Student>() ;
	
	// the filename containing the data to be manipulated
	String fileName = "assg6_data.txt" ;
	
	/*
	 * loads the lines of the text file into whatever we would like, in this case a student list
	 * @param	fileName	the name of the file to evaluate
	 */
	public void loadData(String fileName) {
		
		Scanner inputStream = null ;
		String contents[] ;
		
		Student newStudent ;
		
		try {
			inputStream = new Scanner(new File(fileName)) ;
			
			while(inputStream.hasNextLine())
			{	
				contents = inputStream.nextLine().split(",", 4) ;
			
				newStudent = new Student(contents[0], contents[1], contents[2], contents[3]) ;
				
				studentList.add(newStudent) ;
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found") ;
		}
		
        inputStream.close() ;
	}


	/*
	 * displays the students in the list selected
	 */
	public void displayRoster() {
		for(int i = 0 ; i < studentList.size() ; i++)
		{
			System.out.print(studentList.get(i)) ;
		}
		
	}

	/*
	 * searches a list of students for a student with a matching id
	 * @param	id		the id of the student that we want to find
	 * @return the student with the matching id to the one passed by parameter
	 * @return null if the student cannot be found
	 */
	public Student searchForStudent(String id) {
		
		for(int i = 0 ; i < studentList.size(); i++)
		{
			if(studentList.get(i).getID().equals(id))
				return studentList.get(i) ;
		}
		
		return null ;
	}


	/*
	 * adds a student to the list of students that it is called on
	 * @param	id			the id of the student to add to the list
	 * @param	name		the name of the student to add to the list
	 * @param	standingq	the standing of the student to add to the list
	 * @param	major		the major of the student to add to the list
	 * @return true if the student is added to the list
	 * @return false if the student is not added to the list
	 */
	public boolean addStudent(String id, String name, String standing, String major) {
		
		Student newStudent = new Student(id, name, standing, major);
		studentList.add(newStudent) ;
		
		if(searchForStudent(id) != newStudent)
			return false ;
		
		return true ;
	}

	/*
	 * removes a student from the list of students it is called on
	 * @param	id		the id of the student to remove from the list
	 * @return true if the student is removed
	 * @return false if the student is not removed
	 */
	public boolean removeStudent(String id) {
		
		if(searchForStudent(id) == null)
		{
			System.out.println("ERROR: ID cannot be found!\n") ;
			return false ;
		}
		
		studentList.remove(searchForStudent(id)) ;
		
		if(searchForStudent(id) != null)
			return false ;
		
		return true;
	}

	/*
	 * gets a list of students with the major passed by parameter
	 * @param	major		the major to check for the student to see if they should be added to the list
	 * @return an arrayList of students with the major passed by parameter
	 */
	public ArrayList<Student> getStudentsByMajor(String major) {
		
		ArrayList<Student> majorList = new ArrayList<Student>() ;
		
		for(int i = 0 ; i < studentList.size(); i++)
		{
			if(studentList.get(i).getMajor().equals(major))
				majorList.add(studentList.get(i)) ;
		}
		
		return majorList ; 
	}


	/*
	 * sorts the list that it is called on
	 */
	public void Sort() {
		Collections.sort(studentList);
		System.out.println("Students have been sorted!\n") ;
	}


	/*
	 * saves the list that it is called on if there has been any changes to the file
	 */
	public void Save() {
		
		// Creates a new list to compare current list to
		ArrayList<Student> copyList = new ArrayList<Student>() ;
		
		boolean continueProgram ;
		String contents[] ;
		
		Scanner inputStream = null ;
		PrintWriter outputStream = null ;
		
		// Tries to generate a connection to the file
		try {
			inputStream = new Scanner(new File(fileName)) ;
			
		}catch (IOException e) {
			System.out.println("ERROR: File not found") ;
			
			System.exit(0);
		}
		
		// Fills the copiedList up with the list of students in the file
		while(inputStream.hasNextLine()) {
			contents = inputStream.nextLine().split(",", 4) ;
			
			Student temp = new Student(contents[0], contents[1], contents[2], contents[3]) ;
			
			copyList.add(temp) ;
		
		}
		
		// If the two lists are different then we can continue
		continueProgram = !copyList.toString().contentEquals(studentList.toString());
		 	
		// Resets the copeidList
		for(int i = copyList.size() - 1 ; i >= 0 ; i--)
		{
			copyList.remove(i) ;
		}
		
		// If there are changes between the file and the current roster then it executes
		if(continueProgram)
		{
			try {
				outputStream = new PrintWriter(fileName) ;
			
			}catch (IOException e) {
				System.out.println("ERROR: File not found") ;
				
				System.exit(0);
			}	
			
			for(int i = 0 ; i < studentList.size() ; i++)
			{
				outputStream.print(studentList.get(i).toString()) ;
			}
			
			System.out.println("changes have been made\n"
					+ "students have been saved\n") ;
			
			inputStream.close( );
			outputStream.close( );
		}
		
		else
		{
			System.out.println("no changes have been made\n"
					+ "students have not been saved\n") ;
		}
	}
}
