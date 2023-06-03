import java.util.*;
public class DuplicateParenthesis{
    
    public static boolean isDuplicate(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i< s.length() ; i++){
             char ch = s.charAt(i);
            if(ch == ')'){ //closing
                int count  = 0;
                while(st.peek() != '('){
                    st.pop();
                    count++;
                }
                if(count<1){
                    return true;//it is duplicate
                }else{
                    st.pop();
                }

            }
            else{ //opening
                st.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //valid string
        String s = "(((a+b))+c)";
        String s2 = "((a+b)+c)";
        System.out.println(isDuplicate(s2));    
    }
}