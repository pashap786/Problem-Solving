import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//Given 3 integers i,j and k. Program to find how many numbers between i and j are divisible by k.
class CountDivisors {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
       
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        int dividant = Integer.parseInt(line.split(" ")[2]);
        for(int i=Integer.parseInt(line.split(" ")[0]);i<=Integer.parseInt(line.split(" ")[1]);i++){
            list.add(i);
        }
        
        for(Integer str : list){
            if(str%dividant==0){
                count++;
            }
        }
     
        System.out.println(count);
        
        
    }
}
