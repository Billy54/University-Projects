import java.util.*;
import java.io.*;

class FilterPairs {

	private int k;
	private HashMap<String,HashSet<String>> UBMap = new HashMap<String,HashSet<String>>(); 
	private HashMap<String,HashSet<String>> BUMap = new HashMap<String,HashSet<String>>();
	
	public FilterPairs(int K){
		k = K;
	}
	public void readFile(String file) throws FileNotFoundException{
		Scanner reader =  new Scanner(new FileInputStream(file));
		while(reader.hasNextLine()){
			String[] line = reader.nextLine().split(" ");
			if(!UBMap.containsKey(line[0])){
				UBMap.put(line[0],new HashSet<String>());
			}
			UBMap.get(line[0]).add(line[1]);
			if(!BUMap.containsKey(line[1])){
				BUMap.put(line[1],new HashSet<String>());
			}
			BUMap.get(line[1]).add(line[0]);
		}
		reader.close();
	}
	public void filter(){
		for(String key : UBMap.keySet()){
			if(UBMap.get(key).size()<k){
				for(String t : UBMap.get(key)){
					if(BUMap.get(t).contains(key)){
						BUMap.get(t).remove(key);
					}
				}
			}	
		}
		for(String key : BUMap.keySet()){
			if(BUMap.get(key).size()<k){
				for(String t : BUMap.get(key)){
					if(UBMap.get(t).contains(key)){
						UBMap.get(t).remove(key);
					}
				}
			}
		}
	}
	public void printFile(String file) throws FileNotFoundException{
		PrintWriter outputWriter = new PrintWriter(new FileOutputStream(file));  
		for(String key : UBMap.keySet()){
			if(UBMap.get(key).size()>=k){
				for(String value : UBMap.get(key)){
					outputWriter.println(key +" "+ value);
				}
			}
		}
		outputWriter.close();
	}
}
