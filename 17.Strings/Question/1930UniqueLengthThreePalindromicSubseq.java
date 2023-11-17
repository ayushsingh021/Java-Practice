// Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

// Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

// A palindrome is a string that reads the same forwards and backwards.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
 

// Example 1:

// Input: s = "aabca"
// Output: 3
// Explanation: The 3 palindromic subsequences of length 3 are:
// - "aba" (subsequence of "aabca")
// - "aaa" (subsequence of "aabca")
// - "aca" (subsequence of "aabca")
// Example 2:

// Input: s = "adc"
// Output: 0
// Explanation: There are no palindromic subsequences of length 3 in "adc".
// Example 3:

// Input: s = "bbcbaba"
// Output: 4
// Explanation: The 4 palindromic subsequences of length 3 are:
// - "bbb" (subsequence of "bbcbaba")
// - "bcb" (subsequence of "bbcbaba")
// - "bab" (subsequence of "bbcbaba")
// - "aba" (subsequence of "bbcbaba")
 


// Constraints:

// 3 <= s.length <= 105




class Solution {
    public int countPalindromicSubsequence(String s) {
        //edge
        if(s.length() == 3){
           if( s.charAt(0 ) == s.charAt(2) ) {
               return 1;
            }else{
                return 0;
            }
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            hm.put(ch , i );
        }
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if( hm.containsKey(ch) && hm.get(ch) > i){
                int end = hm.get(ch);
                // System.out.print( i + " " + end);
                for(int j = i+1 ; j < end ; j++){
                    char unique = s.charAt(j);
                    set.add(unique);
                    // System.out.println(set);
                }
                ans += set.size();
                set.clear();
                hm.remove(ch);
            }
            
        }
        System.out.print(hm);

        return ans;


    }
}