public class quesFour {
    
    static int count = 0;

    public static int countString(String str){
        //base case
        if(str.length()==0){
            return 0 ;
        }
        //recursion
            for(int j=1; j<=str.length(); j++){
                
                    String newstr = str.substring(0, j);
                    if(newstr.charAt(0) == newstr.charAt(newstr.length()-1)){
                        count++;
                        // System.out.print(newstr + " ");
                    
                }
              
               
            }
        countString(str.substring(1));
        return count;

    }
    public static void main(String[] args) {
        String str = "aba";
        System.out.println();
        System.out.println("The no of req substrings are : "+countString(str));
    }
    
}
