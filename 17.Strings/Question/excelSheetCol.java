// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

// For example:

// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28 
// ...
 

// Example 1:

// Input: columnNumber = 1
// Output: "A"
// Example 2:

// Input: columnNumber = 28
// Output: "AB"
// Example 3:

// Input: columnNumber = 701
// Output: "ZY"



class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder("");
        while(columnNumber  > 0){
            int r = (columnNumber - 1)%26;
            sb.append((char)('A'+r));
            columnNumber = (columnNumber - 1)/26;
        }
        return sb.reverse().toString();
    }
}


///Method 2
class Solution
{
    String colName (long n)
    {
       String str = "";
       ArrayList<Long> ans = new ArrayList<>();
    //   System.out.print('T'-64);
      while(n > 0 ){
          long dig = n%26;
          if(dig !=0  ){
              ans.add(dig);
          }else{
             ans.add((long)26);
             n= n-1;
          }
           n = n/26;
      }
      for(int i = ans.size() - 1; i >= 0 ; i--){
          str = str + (char)( 64 + ans.get(i));
      }
       return str;
    }
}
