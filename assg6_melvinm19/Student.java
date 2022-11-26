/*
 * @Author Grant Melvin
 * Class to Create student objects and methods for the StudentList class
 */
package assg6_melvinm19;

public class Student implements Comparable<Student>{
	
	// instance variables for student object
	private String id, name, standing, major ;
	
	public Student(String id, String name, String standing, String major) {
		this.id = id ;
		this.name = name ;
		this.standing = standing ;
		this.major = major ;
		}	
	
	/*
	 * gets the ID of the selected student
	 * @return the ID value of current student
	 */
	public String getID() {
		return this.id ;
	}

	/*
	 * gets the name of the selected student
	 * @return the name value of current student
	 */
	public String getName() {
		return this.name ;
	}
	
	/*
	 * gets the standing of the selected student
	 * @return the standing value of current student
	 */
	public String getStanding() {
		return this.standing ;
	}
	
	/*
	 * gets the major of the selected student
	 * @return the major value of current student
	 */
	public String getMajor() {
		return this.major ;
	}
	
	/*
	 * sets the id of the selected student to the id passed by paramter
	 * @param	id	  id to be passed to new student
	 */
	public void setID(String id) {
		this.id = id ;
	}
	
	/*
	 * sets the name of the selected student to the name passed by paramter
	 * @param	name	  id to be passed to new student
	 */
	public void setName(String name) {
		this.name = name ;
	}
	
	/*
	 * sets the standing of the selected student to the standing passed by paramter
	 * @param	standing	  id to be passed to new student
	 */
	public void setStanding(String standing) {
		this.standing = standing ;
	}
	
	/*
	 * sets the major of the selected student to the major passed by paramter
	 * @param	major	  id to be passed to new student
	 */
	public void setMajor(String major) {
		this.major = major ;
	}
	
	/*
	 * prints the students id, name, standing, and major
	 * @return the id, name, standing, and major of the student selected
	 */
	public String toString() {
		return this.getID() + "," + this.getName() + "," + this.getStanding() + "," + this.getMajor() + "\n" ;
	}
	
	/*
	 * tests to see if two students are equal or not if they have the same id
	 * @param	student		the student to compare the selected student to
	 * @return false if the students are not equal
	 * @return true if the students are equal
	 */
	public boolean equals(Student student) {
		if(student == null)
			return false ;
		
		if(student instanceof Student)
		{
			Student temp = (Student)student ;
			
			return this.id.equals(temp.id) ;
		}
		
		return false ;
	}
	
	/*
	 * tests to see if two students are equal or not if they have the same id
	 * @param	student		the student to compare the selected student's id to
	 * @return 0 if the students are equal
	 * @return < 1 if the student passed by parameter is less than the selected student id 
	 * @return > 1 if the student passed by parameter is greater than the selected student id 
	 */
	@Override
	public int compareTo(Student student) {
		if(student != null)
			return this.id.compareTo(student.id) ;
	return 0;
	}
}