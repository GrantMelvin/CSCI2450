/*
 * @author Grant Melvin
 * @author Jaxon Baeur
 */

package activity11;

import java.util.* ;

public class MergeTest {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in) ;
		
		ArrayList<Integer> list1 = new ArrayList<Integer>() ;
		ArrayList<Integer> list2 = new ArrayList<Integer>() ;
		ArrayList<Integer> list3 = new ArrayList<Integer>() ;
		
		for(int i = 0 ; i < 10 ; i++) {
			list1.add(i) ;
		}
		
		for(int i = 30 ; i > 20 ; i--) {
			list2.add(i) ;
		}
		
		list3 = merge(list1,list2) ;
		
		for(int i = 0 ; i < list3.size() ; i++) {
			System.out.println(list3.get(i)) ;
		}
	}

	
	public static ArrayList<Integer> merge(ArrayList<Integer> list1, 
			ArrayList<Integer> list2){
		
		ArrayList<Integer> returnList = new ArrayList<Integer>() ;

		while(list1.size() > 0 && list2.size() > 0) {
			if(list1.get(0) < list2.get(0)) {
				returnList.add(list1.get(0));
				list1.remove(0) ;
			}
			else{
				returnList.add(list2.get(0));
				list2.remove(0) ;
			}
		}
	
		
		return returnList;
	}
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> list){
		
		ArrayList<Integer> returnList1 = new ArrayList<Integer>() ;
		ArrayList<Integer> returnList2 = new ArrayList<Integer>() ;
		
		for(int i = 0 ; i < list.size() / 2 ; i++) {
			returnList1.add(list.get(i)) ;
			list.remove(i) ;
		}
		
		
		for(int i = 0 ; i < list.size(); i++) {
			returnList2.add(list.get(i)) ;
		}
		
		if(returnList1.size() > 0 && returnList2.size() > 0) {
			mergeSort(returnList1) ;
			mergeSort(returnList2) ;
		}
		
		return merge(returnList1, returnList2) ;
	}
}
