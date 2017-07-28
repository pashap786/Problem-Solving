
import java.util.*;
class CheckTreeStructure {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();  
		System.out.println(checkTree(N));		
    }
	
	//return Yes if Graph is a tree, return No if Graph is not a tree structure
	public static String checkTree(int vertices){
		int sum=0;
        for(int i=0;i<N;i++){
            sum=sum+s.nextInt();
        }
        if(sum==2*(N-1)){
            return "Yes";
        }
        else{
            return "No";
        }
	}
}
