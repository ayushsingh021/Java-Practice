
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.



class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int l =0 ;
        HashSet<Character> set = new HashSet<>();
        for(int  r = 0 ; r < s.length() ; r++){
            char ch = s.charAt(r);
            if( set.contains(ch)){
                while(l<r && set.contains(ch)){
                      set.remove(s.charAt(l));
                      l++;
                } 
            }
            set.add(ch);
            ans = Math.max(ans , r-l+1);
        }
        return ans;
    }
}