public class subserArr {

    public static void subsetFind(String str, String ans , int i){
        //base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
            System.out.println(ans);
            }
            return;
        }

        //recurion
        //choice yes to the char
        subsetFind(str, ans + str.charAt(i), i+1);
        //choice No to the char
        subsetFind(str, ans, i+1);


    }
    public static void main(String[] args) {
        String str = "abc";
        subsetFind(str, "", 0);
    }
    
}
