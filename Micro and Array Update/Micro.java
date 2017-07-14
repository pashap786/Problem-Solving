
import java.util.*;
class Micro {
    public static void main(String args[] ) throws Exception {
       
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] numberArray = new int[N];
        int[] smallArray = new int[N];
        for(int i=0;i<N;i++){
            int small=Integer.MAX_VALUE;
            int size = s.nextInt();
            int number = s.nextInt();
            numberArray[i]=number;
            for(int j=0;j<size;j++){
                int el = s.nextInt();
                if(small>el){
                    small=el;
                }
            }
            smallArray[i]=small;
        }
 
        for(int i=0;i<smallArray.length;i++){
          //  System.out.println(smallArray[i]+" "+numberArray[i]);  
            if(smallArray[i]>=numberArray[i]){
               System.out.println(0); 
            }
            else{
               System.out.println(Math.abs(smallArray[i]-numberArray[i]));    
            }
        }
        
    }
}
