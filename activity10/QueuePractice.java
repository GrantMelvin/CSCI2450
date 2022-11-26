package activity10;

import java.util.* ;

public class QueuePractice {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in) ;
		
		System.out.print("Please enter an integer: ") ;
		int userNum = kbd.nextInt() ;
		
		Node head = listGenerator(userNum);
		
		Node newNode = head ;
		
		while(newNode != null)
		{
			System.out.print(newNode.item + "\t") ;
			
			newNode = newNode.next ;
		}	
		
		System.out.println(); 
		
		queueTest(head) ;
		
	}

	
	static Node listGenerator(int size) {
		
		  Node head = null ;
		  
		  int n ;
	        
	        for(int i = 0 ; i < size ; i++)
	        {    

	        	Random rand = new Random();    // only need to be called once

	        	n = rand.nextInt(50);    // each time rand.nextInt is called, it will generate a random number within 50
	        	
	            if(head == null)
	            {
	                Node newNode = new Node(n) ;
	                head = newNode ;
	            }
	            else
	            {
	                Node newNode = head ;
	                
	                while(newNode.next != null)
	                {
	                    newNode = newNode.next ;
	                }
	                
	                newNode.next = new Node(n) ;
	            }
	            
	        }
	        
	        return head ;
	}
	
	static void queueTest(Node start) {	
		ArrayDeque<Node> queue = new ArrayDeque<Node>();
		
		Node node = start ;
		
		while(node != null) {
			queue.add(node) ;
			node = node.next ;
		}
		
		Iterator<Node> itr = queue.iterator() ;
		
		while(itr.hasNext()) {
			System.out.print((itr.next().item * 2) + "\t") ;
		}
	}
}
