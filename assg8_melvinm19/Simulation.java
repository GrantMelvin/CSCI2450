/*
 * @ Author Grant Melvin
 */
package assg8_melvinm19;

import java.util.* ;
import java.io.* ;

public class Simulation{

	public static void main(String[] args) {
		
		Scanner inputStream = null ;		
		int currentTime = 1 ;				
		
		int peopleCounter = 0 ;
		double waitingTime = 0 ;
		
		// Creates the data structures used to keep track of what's going on
		Queue<Event> queue = new LinkedList<> ();
		EventList eventList = new EventList() ;
		
		// Tries to establish a connection to the file and adds the first event to the eventList
		try {
			inputStream = new Scanner(new File("assg8_input.txt")) ;

			Event event = new Event('A',Integer.parseInt(inputStream.next()), Integer.parseInt(inputStream.next()));

			eventList.addEvent(event) ;		
			waitingTime += event.getTransactionTime() ;
		
				
		}catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found") ;
		}
		
		// Beginning of simulation
		System.out.println("Simulation Begins") ;
		while(!eventList.isEmpty()) {
			
			Event newEvent = eventList.list.remove(0) ;
			
			eventList.addEvent(newEvent) ;
	
			currentTime = newEvent.getTime() ;
		
			// Event is arrival
			if(newEvent.isArrival()) {
				processArrival(eventList, queue, newEvent, currentTime, inputStream) ;
				System.out.println("Processing an arrival at time: " + currentTime) ;
				waitingTime += newEvent.getTransactionTime();
			}
			
			// Event is departure
			else{
				processDeparture(eventList, queue, newEvent, currentTime) ;
				System.out.println("Processing a departure at time: " + currentTime) ;
				peopleCounter++ ;
			}	
		}
	
		waitingTime /= peopleCounter ;
		
		// Prints final statistics
		System.out.println("Simulation Ends") ;
		System.out.println("\nFinal Statistics: ") ;
		System.out.println("Total number of people processed: " + peopleCounter) ;
		System.out.println("Average time of waiting spent: " + waitingTime) ;
		
	}
	
	/*
	 * Processes the arrival event by adding it to the queue and removing it from the eventList
	 * If it is at the front of the queue then it creates and inserts the appropriate departure event 
	 * If it we are not at the end of the file then it will create an arrival event for the next incoming event
	 * @param	eventList		used to keep track of the events that need to occur and the order they occur in
	 * @param	queue			used to keep track of what kind of events and how many events are waiting to be processed
	 * @param	event			used to manipulate the current event
	 * @param	currentTime		used to keep track of the time it is at this point in the file
	 * @param	inputStream		used to pull an arrival event from the input file if there is more events left to be processed
	 */
	public static void processArrival(EventList eventList, Queue<Event> queue, Event event, int currentTime, Scanner inputStream) {
		
		boolean atFront = queue.isEmpty() ;

		queue.add(event) ;
		eventList.removeEvent(event) ;
		
		if(atFront) {
			Event newEvent = new Event('D', currentTime + event.getTransactionTime()) ;
					
			eventList.addEvent(newEvent) ;
			
		}
		
		if(inputStream.hasNextLine()) {
			Event addedEvent = new Event('A',Integer.parseInt(inputStream.next()), Integer.parseInt(inputStream.next()));
				
			eventList.addEvent(addedEvent) ;
			
		}
	}
	
	/*
	 * Processes the departure event by removing the head of the queue and the first item in event list
	 * If the queue is not empty then it will create a new event with the top of the queues' event and place it into the eventList
	 * @param	eventList		used to keep track of the events that need to occur and the order they occur in
	 * @param	queue			used to keep track of what kind of events and how many events are waiting to be processed
	 * @param	event			used to manipulate the current event
	 * @param	currentTime		used to keep track of the time it is at this point in the file
	 */
	public static void processDeparture(EventList eventList, Queue<Event> queue, Event event, int currentTime) {
	
		queue.remove();

		eventList.removeEvent(event) ;
		
		if(!queue.isEmpty()) {
				
			Event newEvent = queue.peek() ;
			Event addedEvent = new Event('D', newEvent.getTransactionTime() + currentTime) ;
			
			eventList.addEvent(addedEvent) ;
		}
	}
}
