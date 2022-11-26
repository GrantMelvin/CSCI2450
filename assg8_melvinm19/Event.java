/*
 * @ Author Grant Melvin
 */
package assg8_melvinm19;

public class Event {
	
	// Creates the variables used for an event
	char eventType ;
	int time ;
	int transactionTime ;

	/*
	 * Constructor for an event with no transaction time
	 * @param	eventType	the type of event, arrival or departure
	 * @param	time		the time that the event took place
	 */
	public Event(char eventType, int time) {
		this.eventType = eventType ;
		this.time = time ;
	}
	
	/*
	 * Constructor for an event with transaction time included
	 * @param	eventType			the type of event, arrival or departure
	 * @param	time				the time that the event took place
	 * @param	transactionTime		the amount of time that the transaction takes place
	 */
	public Event(char eventType, int time, int transactionTime) {
		this.eventType = eventType ;
		this.time = time ;
		this.transactionTime = transactionTime ;
	}
	
	/*
	 * Retrieves the type of an event for the one that it is called on
	 * @return the type of event, 'A' or 'D'
	 */
	public char getEventType() {
		return this.eventType ;
	}
	
	/*
	 * Retrieves the time of an event for the one that it is called on
	 * @return the time that the event took place
	 */
	public int getTime() {
		return this.time ;
	}
	
	/*
	 * Retrieves the transaction time of an event for the one that it is called on
	 * @return the amount of time that the event takes to occur
	 */
	public int getTransactionTime() {
		return this.transactionTime ;
	}
	
	/*
	 * Prints the event that it is called on
	 * @return the event type, time, and transaction time if it is an arrival event
	 * @return the event type and time if it is a departure event
	 */
	public String toString() {
		if(this.eventType == 'A') {
			return "{" + this.getEventType() + ", " + this.getTime() + ", " + this.getTransactionTime() + "}" ;
		}
		else
			return "{" + this.getEventType() + ", " + this.getTime() + "}" ;

	}
	
	/*
	 * Checks to see if an event is an arrival event
	 * @return true if the event is an arrival event
	 * @return false if the event is not an arrival event
	 */
	public boolean isArrival() {
		return this.eventType == 'A' ;
	}
	
	/*
	 * Checks to see if an event is a departure event
	 * @return true if the event is a departure event
	 * @return false if the event is not a departure event
	 */
	public boolean isDeparture() {
		return this.eventType == 'D' ;
	}
	
	/*
	 * Compares two events together to see which one occurs first
	 * @param	event	the event to compare the event that this is called on to
	 * @return 0 if the events are equal to eachother
	 * @return 1 if the parameter event occurs before the event that it is called on 
	 * @return -1 if the parameter event is occurs after the event that it is called on
	 */
	public int compareTo(Event event) {
		return this.compareTo(event) ;
	}
}
