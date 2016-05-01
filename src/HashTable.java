import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
/**
*Rafal Bielech
*
*HashTable implementation
*
*3/17/2016
*
*rbielech@gmail.com
*
**/

public class HashTable
{
	/** Defined functions and fields that will be used later on */
	Quicksort q = new Quicksort();
    HashFunction h = new HashFunction(); 
	Node[] array; //table of Nodes
    int size; //size field
    Node head;
  
 
    /* Constructor */
    public HashTable()
    {
    	/** Allocated size of 5 million to avoid any unecessary collision */
    	array = new Node[5000000];
        size = 0;
        
    }
    /** This function is passed a string which later gets sorted, hashed, and made into a new node which gets inputted to table */
    public void insert(String string)
   {
    	int nbucket;
        String srtstrng = q.sort(string);   //passed string gets quicksorted 
        //long code = HashFunction.hashCode(srtstrng); // hashed to a long code
        long code = h.hashCode(srtstrng);
        int bucket = h.hash(srtstrng);
        nbucket = bucket;
        Node node = new Node(code,string);   //new Node is formed containing the string and hashCode             
        if(array[bucket] == null){ //if array of Node is empty in the position that the mod operations points to , then put the node there. 
        	array[bucket] = node;
        	head = node;
        	array[bucket].size++;
        	}
        else{
        	if((head.key == node.key)){
            node.next = array[bucket]; //if it is not empty then chain the next node to this one. 
            array[bucket] = node;
        	}
        	//if the key matches then chain onto the next one
        	else{
        		if((head.key != node.key)){
                    node.next = array[bucket]; //if it is not empty then chain the next node to this one. 
                    array[bucket] = node;
                	}
        		else{
        			{
        				//if it does not match, then find another empty container and put the nodes in it.
        			do{
        			nbucket = (nbucket + 1) % 5000000-1;
        			}
        			while(array[bucket]!= null );
        			 node.next = array[nbucket]; //if it is not empty then chain the next node to this one. 
                     array[nbucket] = node;
        		}
        			
        		}
        }
        }
        size++; // increment the size
    }
        	

    public void printHashTable ()
    {	

        System.out.println("		");
        for (int i = 0; i < array.length; i++)
        {	
        	//for the size of the array assign each e

        	if(array[i] == null){
        		/** if that slot is empty, move onto the next slot */
        		i++;
        	}
        	else {
            while(array[i] != null)
            {
            	/** check through all the slots until there is nothing null pointer */
                System.out.print(array[i].data +" " );
                array[i] = array[i].next; 
                //moving onto the next
            }
            System.out.println("");
        	}
        }

    }   
   
    
    /** prints the array to the specified file name */
    public void printHTfile(String a)
    {
    	File file = new File(a);
		try {
			file.createNewFile();
			PrintStream writer = new PrintStream(file);
			for (int i = 0; i < array.length; i++)
	        {	
	        	if(array[i] == null){
	        		/** if that slot is empty, move onto the next slot */
	        		i++;
	        	}
	        	else {
	            while(array[i] != null)
	            {
	            	/** check through all the slots until there is nothing null pointer */
	                writer.print(array[i].data +" "  );
	                array[i] = array[i].next; //moving onto the next
	            }
	           writer.println("");
	        }
	        }
			/** stream flush and close */
			writer.flush();
            writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
    }
}