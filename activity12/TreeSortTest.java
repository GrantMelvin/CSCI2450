package activity12;

import java.io.* ;
import java.util.* ;

class TreeSortTest {

	public static void main(String[] args) {
		
		ArrayList<City> list = new ArrayList<City>() ;
		ArrayList<City>finalList = new ArrayList<City>() ;
		
		Scanner inputStream = null ;
		
		String cityComponents ;
		String[] cityNames = new String[2] ;
		
		
		// Tries to establish a connection to the file and adds the first event to the eventList
		try {
			inputStream = new Scanner(new File("activity12input.txt")) ;

			System.out.println("BEFORE SORTING: ") ;
			
			while(inputStream.hasNextLine()) {
				
			
				cityComponents = inputStream.nextLine() ;
				cityNames = cityComponents.split(",") ;
				
				City city = new City(cityNames[0], cityNames[1]) ;
				
				list.add(city) ;
				
				System.out.println(city.toString()) ;
			}
		
				
		}catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found") ;
		}
		
		System.out.println("\nAFTER SORTING: ") ;

		finalList = treeSort(list) ;
		
		for(int i = 0 ; i < finalList.size() ; i++) 
			System.out.println(finalList.get(i)) ;
		
	}
	
	public static ArrayList<City> treeSort(ArrayList<City> unsortedList){
		
		BinarySearchTree<City, String> tree = new BinarySearchTree<City, String>() ;
		
		ArrayList<City> sortedList = new ArrayList<City>() ; 
		
		Iterator<City> iter = unsortedList.iterator() ;
		
		while(iter.hasNext()) {
			tree.insert(iter.next());
		}
		
		TreeIterator<City> iter2 = new TreeIterator<City>(tree) ;
		iter2.setInorder() ;
		
		while(iter2.hasNext()) {
			sortedList.add(iter2.next()) ;
		}		
		
		return sortedList ;
	}

}
