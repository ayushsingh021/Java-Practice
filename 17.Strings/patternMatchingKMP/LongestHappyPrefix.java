// A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

// Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

 

// Example 1:

// Input: s = "level"
// Output: "l"
// Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
// Example 2:

// Input: s = "ababab"
// Output: "abab"
// Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
 

// Constraints:

// 1 <= s.length <= 105
// s contains only lowercase English letters.

class Solution {
    public static void KMPlps(String str , int lps[] ){
        int n = str.length();
        int pre =0, suf =1;
       
        while(suf < n){
            if(str.charAt(pre) == str.charAt(suf)){
                lps[suf] = pre +1;
                pre++;
                suf++;
            }else{
                if( pre == 0){
                    lps[suf] = 0;
                    suf++;
                }else{
                    pre = lps[pre-1];
                }
            }
        }
    }
    public String longestPrefix(String s) {
        int lps[] = new int[s.length()];
        KMPlps(s ,lps);
        int maxLen = lps[s.length()-1];
        String ans = "";
        for(int i = 0 ; i < maxLen ; i++){
            ans += s.charAt(i);
        }
        return ans;
    }
}