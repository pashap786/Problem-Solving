import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import javafx.util.Pair; 

public class CalculateMinimumSwapArraySort {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

         int n = arr.length; 
         List<Pair<Integer,Integer>> array = new ArrayList<Pair<Integer,Integer>>();
         for(int i=0;i<n;i++){
             array.add(new Pair<Integer,Integer>(arr[i],i));
         }
         array.sort(new Comparator<Pair<Integer,Integer>>(){
             public int compare(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2){
                 if(p1.getKey()>p2.getKey()){
                     return 1;
                 }
                 else if(p1.getKey()<p2.getKey()){
                     return -1;
                 }
                 else return 0;
             }
          }
         
         );
        
        
        boolean[] visit = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visit[i] || array.get(i).getValue()==i){
                continue;
            }
            int j=i;
            int cycle=0;
            while(!visit[j]){
                visit[j]=true;
                j=array.get(j).getValue();
                cycle++;
            }
            if(cycle>0){
                count+=cycle-1;
            }
        }
        return count;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
