import java.util.Scanner;

public class Nsum {

    public static int printSum(int a){
        if(a==1){
            return 1;
        }
        int Snm1= printSum(a-1);
        int Snm= a + Snm1;
        return Snm;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(printSum(a));
        sc.close();
    }
}
