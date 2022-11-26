package activity5;

import java.io.* ;
import java.util.* ;

public class FileInputOutputPractice {

	public static void main(String[] args) {
		

		String filename1 = "activity5_input1.txt" ;
		String filename2 = "activity5_input2.txt" ;
		Scanner inputStream = null ;
		String line ;
		
		String outFile = "activity5_output.txt" ;
		PrintWriter outputStream = null ;
		
		try {
			inputStream = new Scanner(new File(filename1)) ;
			}catch (FileNotFoundException e) {
				System.out.println("Error openning the file " + filename1) ;
				System.exit(0) ;
			}
		
		try {
			outputStream = new PrintWriter(outFile) ;
			}catch(IOException e) {
				System.out.println("Error opening the file " + 
                        outFile);
				System.exit(0);
			}
		
		while (inputStream.hasNextLine()) {
			line = inputStream.nextLine() ;
			outputStream.println(line) ;
		}
		
		try {
			inputStream = new Scanner(new File(filename2)) ;
			}catch (FileNotFoundException e) {
				System.out.println("Error openning the file " + filename2) ;
				System.exit(0) ;
			}
		
		while (inputStream.hasNextLine()) {
			line = inputStream.nextLine() ;
			outputStream.println(line) ;
			}
		
		System.out.println("File Created!") ;
		
		outputStream.close() ;
		inputStream.close() ;
	}

}
