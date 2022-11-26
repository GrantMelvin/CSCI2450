/*
 * @ Author Grant Melvin
 */
package assg8_melvinm19;

import java.util.* ;

public class EventList{

	// Creates the list to hold events
	List<Event> list = new ArrayList<Event>() ;
	
	/*
	 * Constructor for a new eventList
	 */
	public EventList() {
		this.list = new ArrayList<Event>() ;
	}
	
	/*
	 * Checks to see if the eventList is empty
	 * @return true if the list is empty
	 * @return false if the list is not empty 
	 */
	public boolean isEmpty() {
		return this.list.size() == 0 ;
	}
	
	/*
	 * Adds an event to the eventList and sorts it at the same time
	 * @param	event	the event that is to be added to the list
	 */
	public void addEvent(Event event) {
		if(list.isEmpty())
			list.add(event) ;
		else{
			if(event.time <= list.get(0).time) {
				Event temp = list.remove(0) ;
				list.add(event) ;
				list.add(temp) ;
			}
			else
				list.add(event) ;
		}
	}
	
	/*
	 * Removes an event from the list
	 * @param	event	the event that is to be deleted from the list
	 */
	public void removeEvent(Event event) {
		list.remove(event) ;
	}
	
	/*
	 * Retrieves a specific event from the list
	 * @param	event	the event that is to be retrieved from the list
	 * @return the event that is being looked for in the list
	 */
	public Event getEvent(Event event) {
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i) == event) {
				return list.get(i) ;
			}
		}
		return null ;
	}
}