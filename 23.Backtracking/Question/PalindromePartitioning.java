// Given a string s, partition s such that every 
// substring
//  of the partition is a 
// palindrome
// . Return all possible palindrome partitioning of s.
// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

class Solution {
    public static boolean cheakPalindrome(String str ,int start , int end){
       while(start <= end){
           if(str.charAt(start++) != str.charAt(end--)){
               return false;
           }
       }
       return true;
    }
    
    public void helper(int idx , String s, List<List<String>> ans , ArrayList<String> ds){     
        if(idx == s.length()){
            ans.add( new ArrayList<>(ds));
            
        }
        for(int i = idx ; i < s.length() ; i++){
            if(cheakPalindrome(s , idx , i)){
                ds.add(s.substring(idx , i+1));
                helper(i +1 , s , ans ,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
         List<List<String>> ans = new ArrayList<>();
         helper(0 , s , ans , new ArrayList<>());
         return ans;
    }
}