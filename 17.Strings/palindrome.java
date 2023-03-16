import java.util.*;
public class palindrome {
    public static boolean cheakPalindrome(String word){
        int n = word.length();
        for(int i = 0 ; i < word.length()/2 ;i++){
              if(word.charAt(i)!=word.charAt(n-i-1)){
                return false;
            }
        }
        return true;
         
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word;
        System.out.println("Enter the word");
        word = sc.next();
        boolean a = cheakPalindrome(word);
        if(a==true){
            System.out.println("The word is a palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }

        
    }
    
}
