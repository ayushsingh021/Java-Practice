public class binString {

    public static void binaryString(int n,  int lastPlace , String str){
        //base case
        if(n==0){
            System.out.println(str);
            return;
        }
        //kaam
        if(lastPlace==0){
            binaryString(n-1, 0, str+"0");
            binaryString(n-1, 1, str+"1");
        }else{
            binaryString(n-1, 0, str+"0");
        }
    }
    public static void main(String[] args) {
        binaryString(3, 0, "");
    }
    
}
