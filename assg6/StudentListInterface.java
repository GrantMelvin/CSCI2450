/*
 * @Author Grant Melvin
 * Class to lay out methods that will be used in the StudentList class
 */
package assg6_melvinm19;

import java.util.ArrayList;

public interface StudentListInterface {
	
	/*
	 * loads the lines of the text file into whatever we would like, in this case a student list
	 * @param	fileName	the name of the file to evaluate
	 */
	public void loadData(String fileName) ;
	
	/*
	 * displays the students in the list selected
	 */
	public void displayRoster() ;
	
	/*
	 * searches a list of students for a student with a matching id
	 * @param	id		the id of the student that we want to find
	 * @return the student with the matching id to the one passed by parameter
	 * @return null if the student cannot be found
	 */
	public Student searchForStudent(String id) ;
	
	/*
	 * adds a student to the list of students that it is called on
	 * @param	id			the id of the student to add to the list
	 * @param	name		the name of the student to add to the list
	 * @param	standingq	the standing of the student to add to the list
	 * @param	major		the major of the student to add to the list
	 * @return true if the student is added to the list
	 * @return false if the student is not added to the list
	 */
	public boolean addStudent(String id, String name, String standing, String major) ;
	
	/*
	 * removes a student from the list of students it is called on
	 * @param	id		the id of the student to remove from the list
	 * @return true if the student is removed
	 * @return false if the student is not removed
	 */
	public boolean removeStudent(String id) ;
	
	/*
	 * gets a list of students with the major passed by parameter
	 * @param	major		the major to check for the student to see if they should be added to the list
	 * @return an arrayList of students with the major passed by parameter
	 */
	public ArrayList<Student> getStudentsByMajor(String major) ;
	
	/*
	 * sorts the list that it is called on
	 */
	public void Sort() ;
	
	/*
	 * saves the list that it is called on if there has been any changes to the file
	 */
	public void Save() ;  
}
