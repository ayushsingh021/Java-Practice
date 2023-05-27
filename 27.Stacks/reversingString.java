import java.util.*;;

public class reversingString {

    public static String reverseString(String str){
        //creating the stack
        Stack<Character> s = new Stack<>();
        int idx = 0;
        //pushing charcaters int he stack
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        //creating the StringBuilder to add char while poping
        StringBuilder result  = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }
    
    public static void main(String[] args) {
        String str = "abc";
        String revStr = reverseString(str);

        System.out.println(revStr);

    }
}
