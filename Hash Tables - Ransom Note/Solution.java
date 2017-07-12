import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) {
        magazineMap = new HashMap<String,Integer>();
        noteMap = new HashMap<String,Integer>();
        
        String[] magazineStr= magazine.trim().split(" ");
        //System.out.println(magazineMap.size());
        for(String temp : magazineStr){
            if(magazineMap.size()==0){
                magazineMap.put(temp,1);
            }
            else if(magazineMap.get(temp)==null){
                magazineMap.put(temp,1);
            }
            else if(magazineMap.get(temp)>=1){
                magazineMap.put(temp,magazineMap.get(temp)+1);
            }
            else{
                magazineMap.put(temp,1);
            }
            
        }

        String[] noteStr= note.split(" ");
        for(String temp : noteStr){
            if(noteMap.size()==0){
               noteMap.put(temp,1); 
            } 
            else if(noteMap.get(temp)==null){
                noteMap.put(temp,1);
            }
            else if(noteMap.get(temp)>=1){
                noteMap.put(temp,noteMap.get(temp)+1);
            }
            else{
                noteMap.put(temp,1);
            }
            
        }
    }
    
    public boolean solve() {
        int count=0;
        for(Map.Entry<String,Integer> nmap : noteMap.entrySet()){
            if(magazineMap.get(nmap.getKey())>=1 && magazineMap.get(nmap.getKey())>=nmap.getValue()){
                count++;
            }
        }
        if(count==noteMap.size()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}