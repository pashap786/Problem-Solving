import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Program to find prime numbers till N, where N is an integer received as stdin.
class PrimeNumbers {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Map<Integer,String> map = new LinkedHashMap<Integer,String>();
        for(int i=2;i<Integer.parseInt(line);i++)
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
