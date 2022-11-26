package townGenerator;
import java.util.* ;
import java.io.* ;

public class Generator {

	public static void main(String[] args) {
		
		final int SIZE = 5 ; // how many towns do we want to generate
		
		ArrayList<Town> townList = new ArrayList<Town>() ;
		
		Scanner kbd = new Scanner(System.in) ;
		int townChoice ;
		
		FileWriter fw = null ;
		BufferedWriter bw = null ;
		PrintWriter pw = null ;
		
		Town pickedTown = null ;
		
		for(int i = 0 ; i < SIZE ; i++)
		{
			townList.add(new Town()) ; 
		}
		
		menu(townList) ;
		
		System.out.println("Enter the corresponding number to one that you like. "
				+ "\n0 to exit.") ;
		
		while(true) {
			townChoice = kbd.nextInt() ;
			
			if(townChoice == 0)
				break ;
			
			pickedTown = selectTown(townChoice, SIZE, townList) ;
			
			try {
				
				fw = new FileWriter("goodTowns.txt", true) ;
				bw = new BufferedWriter(fw) ;
				pw = new PrintWriter(bw) ;
				
				pw.println(pickedTown) ;
				pw.flush() ;
				
			}catch(IOException e) {}
			
			System.out.println("Select another town if you'd wish.\n0 to exit.") ;
		}
		
			try {
				if(fw != null)
					fw.close() ;
				if(bw != null)
					bw.close() ;
			} catch (IOException e) {}
		
		if(pw != null)
			pw.close() ;
		
		kbd.close() ;

	}
	
	public static void menu(ArrayList<Town> list) {
		for(int i = 0 ; i < list.size() ; i++)
			System.out.println(i+1 + ": " + list.get(i)) ;
	}

	public static Town selectTown(int num, int SIZE, ArrayList<Town> list) {
		for(int i = 0 ; i < SIZE ; i++) {
			if(num == i + 1) {
				return list.get(i) ;
			}
		}
		return null ;
	}
}
