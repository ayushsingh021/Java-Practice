public class testing{
   
   public static void main(String[] args) {
    
    String s = "A man, a plan, a canal: Panama";
    String str = s.replaceAll("[^a-zA-Z0-9]","");
    System.out.println(str);
   }

}