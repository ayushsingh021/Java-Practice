// Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

// Example 1:

// Input:
// S = "aabacbebebe", K = 3
// Output: 
// 7
// Explanation: 
// "cbebebe" is the longest substring with 3 distinct characters.


//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int l = -1;
        int r = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = -1;
        while(true){
            boolean f1 = false;
            boolean f2  = false;
            //aquire
            while(r < s.length() - 1){
                f1  = true;
                r++;
                char ch = s.charAt(r);
                map.put(ch , map.getOrDefault(ch , 0) + 1);
                
                if(map.size() < k){
                    continue;
                }else if(map.size() == k){
                    int len = (r-l);
                    if(len  > ans){
                        ans = len;
                    }
                }
                else{ // map.size() > k -- realease
                    break;
                }
            }
            
            //release
            while( l < r) {
                f2  =true ;
                l++;
                char ch = s.charAt(l);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch , map.get(ch) -1);
                }
                
                if( map.size() > k){
                    continue;
                }else if( map.size() == k){
                    int len = r -l;
                    if(len > ans){
                        ans =len;
                    }
                    break;
                }
            }
            
            if( f1  == false && f2 == false){
                break;
            }
        }
        
        return ans;
    }
}