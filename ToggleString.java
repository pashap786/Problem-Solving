import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.*;
 
//Program to toggle between uppercase and lowercase in a string.
class ToggleString {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int counter = line.length();
        
	//String length can be max 100 chars.    
        if(counter<=100 && counter >= 1){
            char[] ch = line.toCharArray();  
            StringBuilder sbr = new StringBuilder("");
            for(char str : ch){
                if(Character.isUpperCase(str)){
                    sbr.append(Character.toLowerCase(str));
                }
                else if(Character.isLowerCase(str)){
					sbr.append(Character.toUpperCase(str));
                }           
            }     
            System.out.println(sbr);
         }
         
         else{
            System.out.println("String length should be 1 to 100 characters in length");
         }
        
    }
}
