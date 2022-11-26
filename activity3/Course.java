/*
 * Class to be tested by the CourseTest class
 * @author Grant melvin
 */

package activity3;

public class Course {

	private String courseNo ;
	
	private String title ;
	
	private int credit ; 
	
	/*
	 * Constructor used for the two parameter version
	 * @param 	courseNo	course number used for class
	 * @param 	title		course name used for class
	 */
	public Course(String courseNo, String title) {
		this.courseNo = courseNo ;
		
		this.title = title ;
		
		this.credit = 3 ;
	}
	
	/*
	 * @param 	courseNo	course number used for class
	 * @param 	title		course name used for class
	 * @param 	credit		course credit hours used for class
	 */
	public Course(String courseNo, String title, int credit) {
		this.courseNo = courseNo ;
		
		this.title = title ;
		
		this.credit = credit ;
	}
	
	/*
	 * Gets the course number when called
	 * @return course number
	 */
	public String getCourseNo() {
		return this.courseNo ;
	}

	/*
	 * Gets the course title when called
	 * @return course title
	 */
	public String getTitle() {
		return this.title ;
	}
	
	/*
	 * Gets the course credit when called
	 * @return course credit number
	 */
	public int getCredit() {
		return this.credit ;
	}
	
	/*
	 * Changes the course title when called
	 * @param	title	title that we want to update variable with
	 */
	public void setTitle(String title) {
		this.title = title ;
	}
	
	/*
	 * Changes the course title when called
	 * @param	credit	credit that we want to update variable with
	 */
	public void setCredit(int credit) {
		this.credit = credit ;
	}
	
	/*
	 * Prints the values of the course
	 * @return course data
	 */
	public String toString() {
		return courseNo + " - " + title + " (" + credit + ")\n" ;
	}
	
	/*
	 * Prints the values of the course without the credit
	 */
	public void printInfo() {
		System.out.println(courseNo + " - " + title + "\n") ;
	}
}
