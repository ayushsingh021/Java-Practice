//creating lps array
class Solution {
    int lps(String s) {
        int n = s.length();
        int lps[] = new int[n];
        int pre = 0 , suf =1;
        while(suf < n){
            //match
            if(s.charAt(pre) == s.charAt(suf)){
                lps[suf] = pre+1;
                suf++;
                pre++;
            }//not match
            else{
                if(pre ==0){
                    lps[suf] = 0;
                    suf++;
                }else{
                    pre = lps[pre-1];
                }
            }
        }
        
        return lps[n-1];
    }
}
