// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

// Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

// Example 1:

// Input: num1 = "2", num2 = "3"
// Output: "6"
// Example 2:

// Input: num1 = "123", num2 = "456"
// Output: "56088"
 

// Constraints:

// 1 <= num1.length, num2.length <= 200
// num1 and num2 consist of digits only.
// Both num1 and num2 do not contain any leading zero, except the number 0 itself.

//imp
class Solution {

    public static String multiplyString(String s1,String s2 , String ans){
       int n = s1.length();
       int m = s2.length();
       
       if (n == 0 || m == 0){
         return "0";  
       }
       
       long res[] = new long[n+m];
       
       int i = 0 ; 
       int j = 0;
       
       // long sum = 0 ; 
       
       for(int l2 = s2.length()-1 ; l2 >= 0 ; l2 -- ){
           int n2 = s2.charAt(l2)-'0';
           long carry = 0;
           j = 0 ;
           for(int l1 = s1.length() -1 ; l1 >= 0 ; l1 --){
               int n1 = s1.charAt(l1) - '0';
               
              long sum = n1*n2 + res[i+j] + carry;
               carry = sum/10;
               res[i+j] = sum%10;
               j++;
            }
            if(carry > 0){
                res[i+j] += carry;
            }
            i++;
       }
       
       int itr = res.length - 1;
       while(itr >= 0 && res[itr] == 0){
           itr--;
       }
       if(itr == -1){
           return "0";
       }
      
       while(itr  >= 0){
           ans+= res[itr--];
       }
       return ans;
   }
   public String multiply(String s1, String s2) {
        String ans = new String("");
       if((s1.charAt(0) == '-' || s2.charAt(0) == '-') && (s1.charAt(0) != '-' || s2.charAt(0) != '-')){
           ans += '-';
       }
       
       if(s1.charAt(0) == '-'){
           s1= s1.substring(1);
       }
       if(s2.charAt(0) == '-'){
           s2= s2.substring(1);
       }
       String finalAns = multiplyString(s1 ,s2, ans);
       return finalAns;
   }
}