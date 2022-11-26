package assg9_melvinm19;

import java.io.* ;
import java.util.Scanner;

public class CustomerRoster {
	
	// Primary data structure
	BinarySearchTree<Customer, String> tree = new BinarySearchTree<Customer, String>() ;
	
	// Variables used for input from user
	Scanner kbd = new Scanner(System.in) ;
	String input ;
	
	// Temporary variables used to store old data when editing a customer
	String tempID = null ;
	String tempName = null ;
	String tempPhone = null ;
	
	/*
	 * Constructor for a customer roster 
	 * Creates a new customer roster as a binary tree
	 */
	public CustomerRoster() {
		this.tree = new BinarySearchTree<Customer, String>() ;
	}
	
	/*
	 * Displays all customers in the selected customer roster recursively inorder
	 * @param	root	the root of the tree so that we can traverse recursively
	 */
	public void displayCustomers(TreeNode<Customer> root) {
		
		if(root != null) {
			
			displayCustomers(root.leftChild) ;
			
			System.out.println(root.item) ;
			
			displayCustomers(root.rightChild) ;
		}
		
	}
	
	/*
	 * Adds a customer to the customer roster
	 */
	public void addCustomer() {
		
		// Gathers appropriate information from user and verifies that the ID isn't in use
		System.out.println("Whats the ID of the new customer you'd like to add?") ; 
		input = kbd.nextLine() ;
		if(getCustomerID(input).equals("INVALID")){
			tempID = input ;
			
			System.out.println("Whats the name of the new customer you'd like to add?") ; 
			tempName = kbd.nextLine() ;
			
			System.out.println("Whats the phone number of the new customer you'd like to add?") ; 
			tempPhone = kbd.nextLine() ;
			
			// Inserts customer into the tree
			Customer temp = new Customer(tempID, tempName, tempPhone) ;
			tree.insert(temp) ;
			
			System.out.println("Customer successfully added!\n") ;
		}
		else
			System.out.println("Error: Duplicate ID exists\n") ;

	}
	
	/*
	 * deletes a customer from the customer roster
	 */
	public void deleteCustomer() {
		
		// Gathers appropriate information from user
		System.out.println("Whats the ID of the customer you'd like to delete?") ; 
		input = kbd.nextLine() ;
		
		// Verifies that the customer exists
		if(!getCustomerID(input).equals("INVALID")) {
			tree.delete(tree.retrieve(input)) ;
			System.out.println("Student successfully deleted!\n") ;
		}
		else
			System.out.println("Error: Customer doesn't exist\n") ;
	}
	
	/*
	 * Searches for a customer in the customer roster
	 */
	public void searchCustomer() {
		
		// Gathers appropriate information from user
		System.out.println("Whats the ID of the customer you'd like to search?") ; 
		input = kbd.nextLine() ;
		
		if(!getCustomerID(input).equals("INVALID"))
			System.out.println(tree.retrieve(input) + "\n") ;
		else
			System.out.println("Error: Customer doesn't exist\n") ;
	}
	
	/*
	 * Retrieves a customer from the customer roster if they are there
	 * Needs to return a string instead of a customer so that it can catch the null pointer exception 
	 * in the case that the student does not exist
	 * 
	 * @param	key		the ID that we want to search for
	 * @return the customers id if they are a valid customer
	 * @return INVALID if the customer does not exist
	 */
	public String getCustomerID(String key) {
		try{
			return tree.retrieve(key).getKey() ;
		}catch(NullPointerException e) {
			return "INVALID" ;
		}
	}
	
	/*
	 * Edits a customer in the customer roster
	 */
	public void editCustomer() {
		
		// Gathers appropraite information from user
		System.out.println("Whats the ID of the customer you'd like to edit?") ; 
		input = kbd.nextLine() ;
		
		// Verifies that the ID exists in our tree
		if(!getCustomerID(input).equals("INVALID")) {
			tempID = input ;
			
			// Gathers what the user wants to update
			System.out.println("What would you like to edit: ") ;
			System.out.println("1: Name") ;
			System.out.println("2: Phone Number") ;
			System.out.println("3: Both") ;
			input = kbd.nextLine() ;
			
			// Displays and gathers appropriate information based on response
			switch(input) {
			case "1":
				System.out.println("What would you like the new name to be?") ;
				input = kbd.nextLine() ;
				
				tree.retrieve(tempID).setName(input); 
				
				break ;
			case "2":
				System.out.println("What would you like the new phone number to be?") ;
				input = kbd.nextLine() ;
				
				tree.retrieve(tempID).setPhone(input); 
				break ;
			case "3":
				System.out.println("What would you like the new name to be?") ;
				input = kbd.nextLine() ;
				
				tree.retrieve(tempID).setName(input); 
				
				System.out.println("What would you like the new phone number to be?") ;
				input = kbd.nextLine() ;
				
				tree.retrieve(tempID).setPhone(input); 
				
				break ;
			}
			
			System.out.println("Changes successfully made!\n") ;
		}
		else
			System.out.println("Error: Customer doesn't exist\n") ;
	}
	
	/*
	 * Saves the current customers in customer roster recursively to the text file that is passed to it
	 * Same algorithm as the displayCustomers function
	 * @param	root		the root of the tree so that we can traverse inorder
	 * @param	outFile		the PrintWriter variable that prints to the file we want
	 * @param	fileName	the file we want to save the customers to
	 */
	public void saveCustomers(TreeNode<Customer> root, PrintWriter outFile, String fileName) {
		
		// Recursively displays tree with inorder traversal
		if(root != null) {
			
			saveCustomers(root.leftChild, outFile, fileName) ;
			
			outFile.println(root.item);
			
			saveCustomers(root.rightChild, outFile, fileName) ;
		}
		
	}
}
