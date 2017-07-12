import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

class ProfileImageRestriction {
    public static void main(String args[] ) throws Exception {

        BufferedReader size = new BufferedReader(new InputStreamReader(System.in));
        Integer length = Integer.parseInt(size.readLine());
        Integer number = Integer.parseInt(size.readLine());

        List<String> list = new ArrayList<String>();
        for(int i=0;i<number;i++){
            list.add(size.readLine());
        }
      

        for(String str : list){
            
            if(Integer.parseInt(str.split(" ")[0])<length || Integer.parseInt(str.split(" ")[1])<length ){
                System.out.println("UPLOAD ANOTHER");
            }
            else if(Integer.parseInt(str.split(" ")[0]) - Integer.parseInt(str.split(" ")[1]) == 0){
                System.out.println("ACCEPTED");
            }
            else if(Integer.parseInt(str.split(" ")[0])>length && Integer.parseInt(str.split(" ")[1])>length){
                System.out.println("CROP IT");
            }
            else if(Integer.parseInt(str.split(" ")[0])>length || Integer.parseInt(str.split(" ")[1])>length){
                System.out.println("CROP IT");
            }
            else{
                break;
            }
        }
        
    }
}
