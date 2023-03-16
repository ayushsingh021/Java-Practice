import java.util.*;

import javax.sound.midi.Sequencer.SyncMode;
public class anagram{
     
     public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = "race";
    String str2 ="care";
    int count =0;
    for(int i =0; i<str1.length();i++){
        char ch = str1.charAt(i);
        for(int j= 0 ; j< str2.length() ;j++){
            if(ch== str2.charAt(j)){
                count++;
            }
        }
        
    }
    if(count == str1.length()){
        System.out.println("It is an anagram");
    }else{
        System.out.println("not anagram");
    }
     System.out.println();
     sc.close();
    }
}