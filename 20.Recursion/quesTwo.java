public class quesTwo{

    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};

    // public static void spellNum(int num){
    //     int lastDig = num%10;
    //     //base case
    //     if(num==0){
    //         return;
    //     }
    //     spellNum(num/10);

    //     if (lastDig==0){
    //         System.out.print("zero"+" ");
    //     }
    //     if (lastDig==1){
    //         System.out.print("one"+" ");
    //     }
    //     else if(lastDig==2){
    //         System.out.print("two"+ " ");
    //     }
    //     else if(lastDig==3){
    //         System.out.print("three"+ " ");
    //     }
    //     else if(lastDig==4){
    //         System.out.print("four"+ " ");
    //     }
    //     else if(lastDig==5){
    //         System.out.print("five"+ " ");
    //     }
    //     else if(lastDig==6){
    //         System.out.print("six"+ " ");
    //     }
    //     else if(lastDig==7){
    //         System.out.print("seven"+ " ");
    //     }
    //     else if(lastDig==8){
    //         System.out.print("eignt"+ " ");
    //     }
    //     else if(lastDig==9){
    //         System.out.print("nine"+ " ");
    //     }

    // }
    public static void spellNum(int num){
        int lastDig = num%10;
        //base case
        if(num==0){
            return;
        }
        spellNum(num/10);
        System.out.print(digits[lastDig] + " ");
    }
    public static void main(String[] args) {
        int num = 1953;
        spellNum(num);
    }
}