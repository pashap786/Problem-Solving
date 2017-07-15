import java.io.BufferedReader;
import java.io.InputStreamReader;

//Program to check whether a string is Palindrome or not. Program responds with "YES" or "NO" in the console.
class PalindromeStringCheck {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(checkPalindrome(line));

    }
    
    public static String checkPalindrome(String input){
      
        char[] ch = input.toCharArray();
        int i,j;
        
        for(i=0, j=ch.length-1 ; i<j ; i++,j--){
               if(ch[i]!=ch[j]){
                   return "NO";
               }
        }  
        if((i<=ch.length/2) && (j<=ch.length/2)){
          return "YES"; 
        }   
        return null;
    }
        
}
