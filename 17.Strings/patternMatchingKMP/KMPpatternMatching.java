// Given two strings, one is a text string, txt and other is a pattern string, pat. The task is to print the indexes of all the occurences of pattern string in the text string. Use one-based indexing while returing the indices. 
// Note: Return an empty list incase of no occurences of pattern. Driver will print -1 in this case.

// Example 1:

// Input:
// txt = "geeksforgeeks"
// pat = "geek"
// Output: 
// 1 9
// Explanation: 
// The string "geek" occurs twice in txt, one starts are index 1 and the other at index 9. 
// Example 2:

// Input: 
// txt = "abesdu"
// pat = "edu"
// Output: 
// -1
// Explanation: 
// There's not substring "edu" present in txt.

public class Solution
{
    public static void KMPlps(String pat , int lps[]){
        int n = pat.length();
        int pre= 0 ,suf =1;
        while(suf < n ){
            //match
            if(pat.charAt(pre) == pat.charAt(suf)){
                lps[suf] = pre+1;
                suf++;
                pre++;
            }else{
                if(pre == 0){
                    lps[suf] = 0;
                    suf++;
                }else{
                    pre = lps[pre-1];
                }
            }
        }
    }
    ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> ans= new ArrayList<>();
        int lps[] = new int[pat.length()];
        KMPlps(pat , lps);
        int patI = 0, txtI = 0;
        while(txtI < txt.length()){
            if(pat.charAt(patI) == txt.charAt(txtI)){
                //match
                patI++;
                txtI++;
            }
            else if(pat.charAt(patI) != txt.charAt(txtI)){
                if(patI == 0) {
                    txtI++;
                }else{
                    patI = lps[patI-1];
                }
            }
            
            if(patI == pat.length()){
                int Idx = txtI - patI +1;
                ans.add(Idx);
                patI = lps[patI-1];
            }
        }
        
        return ans;
    }
} KMPpatternMatching {
    
}
