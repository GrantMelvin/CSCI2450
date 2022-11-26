package activity13;

import java.io.*;
import java.util.* ;

import assg9_melvinm19.Customer;

public class AirportSim {

	public static void main(String[] args) {
		
		Map<String, String> dictionary = new Hashtable<String, String>();
		String input = "" ;
		Scanner kbd = new Scanner(System.in) ;
		
		String fileName = "activity13_input.txt" ;
		Scanner inputStream = null ;
		String baseAirport ;
		String[] airportContents = new String[2] ;
		String newCode = null ;
		String newCity = null ;
				
		try {
			inputStream = new Scanner(new File(fileName)) ;
					
			// As long as the file has readable lines, it will insert a new customer into the tree
			while(inputStream.hasNextLine()) {
				baseAirport = inputStream.nextLine() ;
				airportContents = baseAirport.split("\t") ;
				dictionary.put(airportContents[0], airportContents[1]);				
				}
			}catch (FileNotFoundException e) {
					System.out.println("ERROR: File not found") ;
			}
			finally {
				inputStream.close() ;
			}
		
		do {
			System.out.println("1. Display all airports/cities") ;
			System.out.println("2. Add a new airport") ;
			System.out.println("3. Search for an airport") ;
			System.out.println("4. Exit") ;
			
			input = kbd.nextLine() ;
			
			System.out.println() ;
			
			switch(input) {
			case "1":
				for (Map.Entry<String,String> entry : dictionary.entrySet()) 
		            System.out.println(entry.getKey() + "\t" + entry.getValue());
				System.out.println() ;
				break ;
			case "2":
				System.out.println("What is the airport code?") ;
				newCode = kbd.nextLine() ;
				System.out.println("What is the city?") ;
				newCity = kbd.nextLine() ;
				
				dictionary.put(newCode, newCity) ;
				
				System.out.println("City successfully added!\n") ;
				
				break ;
			case "3":
				System.out.println("Enter the airport code to search: ") ;
				newCode = kbd.nextLine() ;
				
				System.out.println(dictionary.get(newCode) + "\n") ;
				
				break ;
			}
			
		}while(!input.equals("4")) ;
	}
}
