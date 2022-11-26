package assg9_melvinm19;

import java.util.* ;
import java.io.* ;

public class CustomerMIS {

	public static void main(String[] args) {
		
		CustomerRoster roster = new CustomerRoster() ;
		String fileName = "assg9_CustomerRoster.txt" ;
		boolean continueProgram = true ;
		
		// places the students from the file into the customer roster
		loadData(fileName, roster) ;
		
		do {
			
			// displays the menu for the user
			displayMenu() ;
			
			// decides appropriate action to perform based on user input
			continueProgram = processAction(roster, fileName) ;
			
		}while(continueProgram) ;
	}
	
	
	/*
	 * Loads the students from the file into the customer roster we pass into it
	 * @param	fileName	the file that we want to save the roster into
	 * @param	roster		the roster of students that we want to save into the file 
	 */
	private static void loadData(String fileName, CustomerRoster roster) {
		
		// Basic variables to move the customer into the roster
		Scanner inputStream = null ;
		String baseCustomer ;
		String[] customerContents = new String[3] ;
		
		try {
			inputStream = new Scanner(new File(fileName)) ;
			
			// As long as the file has readable lines, it will insert a new customer into the tree
			while(inputStream.hasNextLine()) {
				baseCustomer = inputStream.nextLine() ;
				customerContents = baseCustomer.split("\t") ;
				Customer temp = new Customer(customerContents[0], customerContents[1],  customerContents[2] ) ;
				roster.tree.insert(temp) ;
			}
		}catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found") ;
		}
		finally {
			inputStream.close() ;
		}
	}
	
	/*
	 * Function that saves the current roster to the desired file
	 * Doesn't need to be a boolean return-type because it will only ever return false,
	 * however, it makes the processAction method look a bit more clean
	 * @param	root		the root of the binary tree that holds the roster, used to traverse recursively in the saveCustomers function
	 * @param	roster		the roster of students we are saving to the file
	 * @param	outFile		the PrintWriter that we are using to write to the file in the parameter
	 * @param	fileName	the name of the file that we are saving the roster to 
	 */
	private static boolean saveData(TreeNode<Customer> root, CustomerRoster roster, PrintWriter outFile, String fileName) {
		
		try {
			outFile = new PrintWriter(fileName) ;
		}catch(FileNotFoundException e) {
			System.out.println("Error: File not found!") ;
			return false ;
		}
		
		roster.saveCustomers(root, outFile, fileName) ;
		outFile.close() ; 
		
		System.out.println("Customers successfully saved!") ;
		
		return false ;
	}
	
	/*
	 * Displays various option for the user to choose from
	 */
	private static void displayMenu() {
		
		System.out.println("1. Display current roster of customers") ;
		System.out.println("2. Add a customer") ;
		System.out.println("3. Delete a customer") ;
		System.out.println("4. Search a customer") ;
		System.out.println("5. Update a customer") ;
		System.out.println("6. Save and Exit") ;
		
	}

	/*
	 * Gathers input from the user and processes what should happen next
	 * @param	roster		the roster of students we are altering in some way
	 * @param	fileName	the file name that we want to save to when the user wants to exit
	 * @return true if the user didnt select to save and exit
	 * @return false if the user did select to save and exit
	 */
	private static boolean processAction(CustomerRoster roster, String fileName) {
		
		@SuppressWarnings("resource")
		Scanner kbd = new Scanner(System.in) ;
		PrintWriter outFile = null ;
		String input = kbd.nextLine() ;
		
		TreeNode<Customer> root = roster.tree.root ;
		
		System.out.println() ;
		
		switch(input) {
		case "1":
			roster.displayCustomers(root) ;
			System.out.println() ;
			break ;
			
		case "2":
			roster.addCustomer() ;
			break ;
			
		case "3":
			roster.deleteCustomer() ;
			break ;
			
		case "4":
			roster.searchCustomer() ;
			break ;
			
		case "5":
			roster.editCustomer() ; 
			break ;
		
		case "6":
			return saveData(root, roster, outFile, fileName) ; 
		}
		
		return true ;
		
	}
}


