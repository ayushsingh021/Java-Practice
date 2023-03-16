public class quesThreestringLength {

    public static int stringLength(String str){
        //basecase
        if(str.length()==0){
            return 0;
        }

        //recursion
        return stringLength(str.substring(1)) + 1;
    }

    public static void main(String[] args) {
        String str = "ayush";
        System.out.println(stringLength(str));
        // System.out.println(str.substring());
        
    }
    
}
