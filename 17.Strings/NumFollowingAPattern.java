
// Given a pattern containing only I's and D's. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can't repeat.

// Example 1:

// Input:
// D
// Output:
// 21
// Explanation:
// D is meant for decreasing, so we choose the minimum number among all possible numbers like 21,31,54,87,etc.
// Example 2:

// Input:
// IIDDD
// Output:
// 126543
// Explanation:
// Above example is self- explanatory,
// 1 < 2 < 6 > 5 > 4 > 3
//   I - I - D - D - D
class Solution{
    public static void reverse(int arr[] , int si , int ei){
        while(si < ei){
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
    }
    static String printMinNumberForPattern(String S){
        int n = S.length();
        int arr[] = new int[n+1];
        
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = i+1;
        }
        
        for(int i = 0 ; i < S.length() ; i++){
            int temp = i ;
            
            while(temp < S.length() && S.charAt(temp) == 'D'){
                temp++;
            }
            
            reverse(arr , i , temp);
            
            if(temp != i ) i = temp-1;
        }
        
        String str = "";
        for(int i = 0 ; i < arr.length ; i++){
            str+=arr[i];
        }
        
        return str;
        
    }
}