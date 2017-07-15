import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.*;
 
//Program to toggle between uppercase and lowercase in a string.
class ToggleString {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(toggleString(line));        
    }
	
    public static String toggleString(String input){
	//String length can be max 100 chars.    
          if(input.length()<=100 && input.length()>= 1){
             StringBuilder sbr = new StringBuilder("");
             for(char str : input.toCharArray()){
                 if(Character.isUpperCase(str)){
                     sbr.append(Character.toLowerCase(str));
                 }
                 else if(Character.isLowerCase(str)){
		     sbr.append(Character.toUpperCase(str));
                 }           
             }     
             return sbr.toString();
          }
         
          else{
             return "String length should be 1 to 100 characters in length";
          }
    }	
}
