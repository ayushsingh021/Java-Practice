//time complexity improved that stringCompress code due to Stringbuilder
import java.util.*;
public class compress2{
    public static String compress(String str){
        StringBuilder newstr = new StringBuilder(" ");
        for(int i = 0; i<str.length(); i++){
            Integer count =1;  //badme hume ise string me comvert bhi to karna hai isliye integer
            while(i< str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newstr.append(str.charAt(i));
            if(count>1){
                newstr.append(count.toString()); 
            }
        }
        return newstr.toString();

    }
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str ="aaabbcccdd";
     System.out.println(compress(str));
     sc.close();
    }
}