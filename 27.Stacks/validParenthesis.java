import java.util.*;
public class validParenthesis {
    
    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            char curr = s.charAt(i);
            if( curr =='(' || curr =='{' || curr =='[' ){
                //opening bracket
                st.push(curr);
            }else{
                //closing bracket
                if(st.isEmpty()){
                    return false;
                }
                if((st.peek() =='(' && curr == ')' )
                || (st.peek() =='{' && curr == '}' )
                || (st.peek() =='[' && curr == ']' )
                ){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
    
    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(isValid(s));
        

    }
}
