/*
 * @author Grant 
 * @auther Keshav
 */

package activity10;

import java.util.* ;

public class QueuePractice2 {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in) ;
		
		System.out.println("Please enter a number: ") ;
		int userNum = kbd.nextInt() ;
		
		Node head = listGenerator(userNum) ;
		
		Node newNode = head ;
		
		while(newNode != null) {
			System.out.print(newNode.item + "\t") ;
			newNode = newNode.next ;
		}

		System.out.println() ;
		
		queueTest(head) ;
		
	}

	
	static Node listGenerator(int num) {
	
		Node head = null ;
		
		int n ;
        
        for(int i = 0 ; i < num ; i++)
        {    
        		
        	Random rand = new Random() ;
        	
        	n = rand.nextInt(50) ; 
        	
            if(head == null)
            {
                Node newNode = new Node(n) ;
                head = newNode ;
            }
            
            else
            {
                Node newNode = head ;
                
                while(newNode.next != null)
                	newNode = newNode.next ;
                
                
                newNode.next = new Node(n) ;
            }
        }
        
        return head ;
	}
	
	static void queueTest(Node head) {
		ArrayDeque<Node> queue = new ArrayDeque<Node>() ;
		
		Node newNode = head ;
		
		while(newNode != null) {
			queue.add(newNode) ;
			newNode = newNode.next ;
		}
		
		Iterator<Node> itr = queue.iterator() ;
		
		while(itr.hasNext()) {
			System.out.print((itr.next().item * 2) + "\t" ) ;
		}
		
	}
}
