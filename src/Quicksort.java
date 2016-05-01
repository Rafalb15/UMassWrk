/** 
---Rafal Bielech
---QuickSort Implementation for sorting strings as char arrays
---3/17/2016
---rbielech@gmail.com
**/

	/*
	The Quicksort is based on the pseudo code found in the Introduction to Algorithm book
	sort method takes in a String and turns it into a char array and that is sorted from the 0th element to the last element and char array is returned as a string. 
	 */
public class Quicksort {
	char[] chararray;

	//This method takes a string which is inputed into a character array
	public String sort(String str){
	  
	  this.chararray = str.toCharArray();
	  int low = 0;
	  int high = chararray.length-1;
	  //the character array is sorted from the begging to end and the array is returned as a string
	  //the char[] was used as a sorting medium
	  quickSort(chararray,low,high);
	  return String.valueOf(chararray);
	}
	
	//Quicksorts the given array of characters, using the partition method which finds the correct place to partition the array
	//the passed char array gets sorted and then the same array is returned. 
	public void quickSort(char[] a,int p,int r){
		if(p < r){
			int q = partition(a,p,r);
			quickSort(a,p,q-1);
			quickSort(a,q+1,r);
	// quicksort uses divide and conquer to keep halving the array into smaller sorted pieces
		}
	}
	
	//partition is found by looking for a good element in the middle to partition the array into two parts. 
	public int partition(char[] a, int p, int r){
		int x = a[r]; //this is the last element in the array
		int i = p - 1; // i = 
		char temporary; //temporary char for exchanging characters
		for(int j = p; j < r; j++){
			if (a[j] <= x){
				//x is taken as the pivot and then the array is sorted until a[j] is greater than x
				i++;
				temporary = chararray[i];
				chararray[i] = chararray[j];
	            chararray[j] = temporary;	
			}
		
		}
		// 
		temporary = chararray[i+1];
		chararray[i+1] = chararray[r];
		chararray[r] = temporary;
		return i+1;
	}
}
