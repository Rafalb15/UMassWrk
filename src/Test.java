import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
*Rafal Bielech
*
*Testing of the functions 
*
*3/17/2016
*
*rbielech@gmail.com
*
**/

public class Test {
	/** Initalize all the classes needed in this section*/
	static Quicksort stringsort = new Quicksort();
	 HashFunction h = new HashFunction();
	static HashTable hash = new HashTable();

	/** This is a method to read a file and write its contents to a string of arrays*/
	public static String[] readLines(String filename) throws IOException {
		/** The file is loaded into the buffered reader */
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        /** LinkedList stores all of the lines with an incrementable counter */
		List<String> reader = new LinkedList<String>();
        String line = "";
        int counter = 0;
        while ((line = bufferedReader.readLine()) != null) {
        	 /** If there is more to read, it is stored in the LinkedList and counter++*/
            reader.add(line);
            counter++;}
        bufferedReader.close();
        /** The List is made into a string array of size counter which is the number of lines*/
        return  reader.toArray(new String[counter]);
    }

	public static void main(String[] args) {
		String [] ar;
		try {
			 /** The file that the user selects is read into the array*/
			System.out.println("What file would you like to read?");
			@SuppressWarnings("resource")
			Scanner a = new Scanner(System.in);
			String input = a.next();
			
			ar = readLines(input);
			long start = System.currentTimeMillis();
			 for(int i = 0; i < ar.length; i++){
				 hash.insert(ar[i]);
			/** The file gets inserted into the hashmap */
			 }
			//System.out.println(hash.printHashTable());
			hash.printHashTable();
			//hash.printHTfile("anagram1");
			long end = System.currentTimeMillis();
			double total = (end - start) * 0.001; 
			 /** The above was used for time testing efficiency */
			 System.out.println("The total time was: " + total);
			
		} catch (Exception e1) {
			e1.printStackTrace();
			
		}	
	}
	
	}


