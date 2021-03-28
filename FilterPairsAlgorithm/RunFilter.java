import java.io.*;

class RunFilter {

	public static void main(String[] args) {
		
		FilterPairs filter = new FilterPairs(3);
		
		try{
			filter.readFile("file.txt");
			filter.filter();
			filter.printFile("file1.txt");
		}
		catch(FileNotFoundException e){
			System.out.println("The file was not found"); 
			System.out.println("or could not be opened.");
			System.exit(-1);
		 }
	}
}
