import java.util.*;

//Program to find prime numbers till N, where N is an integer received as stdin.
class PrimeNumbers {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        findPrime(number);
        
    }
	
    public static void findPrime(int number){
        Map<Integer,String> map = new LinkedHashMap<Integer,String>();
        for(int i=2;i<number;i++)
        {
            map.put(i,"unmarked");
        }
       
	   //change status to 'marked' for all prime numbers.	
	for(int i=2;i<map.size();i++){
         
            	for(Map.Entry<Integer,String> entry : map.entrySet()){
             
                	if(entry.getKey()!=i && entry.getValue()!="marked"){
                    
                    		if( (entry.getKey())%i == 0){
                        		map.put(entry.getKey(), "marked");
                    		}
                	}
                
            	}
              
          }
        
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            if(entry.getValue()!="marked"){
                System.out.print(entry.getKey()+" ");
            }
        }
        
    }
	    
}
