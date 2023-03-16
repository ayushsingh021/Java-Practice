public class permutationString {

    public static void permutationFind(String str ,  String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        //recursion(kaam)
        for(int i = 0 ; i< str.length(); i++){
            char curr = str.charAt(i);
            //abcde =  "ab" + "de" 
            String newStr = str.substring(0, i) + str.substring(i+1); //eliminating the char we used earliar at i 
            permutationFind(newStr, ans+curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        permutationFind(str, "");
    }
    
}
