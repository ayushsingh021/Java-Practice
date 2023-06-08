public class oddOrEven{
    
    public static void isoddOrEven(int n){
        int bitmask = 1; //000000....1  & n 
        if((n & bitmask) == 0){//even
            System.out.println(n +" is even");
        }else{
            System.out.println( n + " is Odd");
        }
    }
    public static void main(String[] args) {
        isoddOrEven(5);
        isoddOrEven(8);
    }
}