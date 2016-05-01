
/**
*Rafal Bielech
*
*Node implementation 
*
*3/17/2016
*
*rbielech@gmail.com
*
**/
//each bucket is a chain on Node which are linked together using .next
//key is the hashcode of passed string
//data is the original passed string
public class Node
{
    Node next;
    String data;
    Long key;
    int size;
    
   /** Each node that is created has a specfic key and the string which is its data*/
    public Node(Long key,String x)
    {	
    	this.key = key;
        this.data = x;
        this.next = null;
        this.size = 1;
    }
    
    public Long getKey(){
    	return this.key;
    }
    
    public String getData(){
    	return this.data;
    }
}