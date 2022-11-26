package activity3;

import assg3_melvinm19.Account;

public class SpecialTopicCourse extends Course{
	
	private String topic ; 
	
	public SpecialTopicCourse(String courseNo, String title, String topic) {
		super(courseNo, title); 
		this.topic = topic ; 
	}
	
	public SpecialTopicCourse(String courseNo, String title, int credit, String topic) {
		super(courseNo, title, credit);
		this.topic = topic ;
	}

	public String getTopic() {
		return this.topic ;
	}
	
	public void setTopic(String topic) {
		this.topic = topic ;
	}
	
	/*
	 * @override
	 */
	public String toString() {
		return getCourseNo() + " - " + getTitle() + "(" + getCredit() + ")" + "(Topic: " + getTopic() + ")"; 
	}
	
	/*
	 * @override
	 */
	public void printInfo() {
		System.out.println(getCourseNo() + " - " + getTitle() + "(Topic: " + getTopic() + ")\n") ;
	}
	
	public boolean equals(SpecialTopicCourse course) {
		if(course == null)
			return false ; 
		
		if(course instanceof SpecialTopicCourse)
		{
			SpecialTopicCourse temp = (SpecialTopicCourse)course ; 
			 	
			if(getCourseNo() == temp.getCourseNo())
			{
				if(getTopic() == temp.getTopic())
					return true ; 
			}
		}
		return false;
	}
}
