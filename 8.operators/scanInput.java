import java.util.*;
public class scanInput{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();  //can take a paragraph(multiword)
        System.out.println(name);

        String nickname = sc.next();   //can take only single word, words after space are neglected
        System.out.println(nickname);
        
        Boolean dec = sc.nextBoolean();
        System.out.println(dec);

        sc.close();

}
}