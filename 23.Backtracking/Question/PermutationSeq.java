// class Solution {


    public static int fact(int n){
        if (n == 0){
           return 1;
        }
       return n * fact(n - 1);
   
   }
   public String helper(String s , StringBuilder ans,int n ,int k){
       if( n == 0){
           return ans.toString();
       }
       int idx = (k)/fact(n-1);
       ans.append(s.charAt(idx));
       String newStr = s.substring(0,idx) + s.substring(idx+1);
       k = k%fact(n-1);
       return helper(newStr, ans ,n-1,k);
       
   }
   public String getPermutation(int n, int k) {
       String s = new String("");
       for(int i= 0 ; i < n ; i++){
           s+=(i+1);
       }
       
       System.out.print(s);
       StringBuilder ans = new StringBuilder();
       return helper(s, ans, n , k-1 );
   }
}