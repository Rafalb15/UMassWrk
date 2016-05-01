/**
*Rafal Bielech
*
*Hashfunction implementation for hashing a string
*
*3/17/2016
*
*rbielech@gmail.com
**/

public class HashFunction {
	 /** This method is use to find the specific hash of the string word */
	//based on the java's way of hashing a string
	//each letter is multiplied by the char representation of it
	public int hash(String word) {
		long hash = 0;
		for(int i = 0; i < word.length(); i++) {
			hash = hash * 31 + word.charAt(i);
		}
		/** Modulus function in order to find where in the table the element belongs in */
		return (int)((hash & 0x7fffffff) % (5000000-1));
		//masked in order to avoid overflow error due to conversion from long to int, 
		
	}
	
		public long hashCode(String word) {
		//prime number 31 is used in many hash functions
		long hash  = 0;
		//loop through the whole word 
		for(int i = 0; i < word.length(); i++) {
			//Generate hash using prime number and char value of each letter
			hash = hash * 31 + word.charAt(i);
		}
		//Return the resultant value of the hash
		return hash;
	}
		
	
	}
