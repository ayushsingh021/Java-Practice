//ye public class hai
public class OOPs{
    public static void main(String[] args) {
        pen  p1 = new pen(); //ye humne ek object bana dia 'p1' --> pen class me
        p1.setColor("Red"); // we accesssed 
        System.out.println(p1.color);
        p1.color = "Yellow";//we can directly access the prop. instead of funcction
        System.out.println(p1.color);
        p1.setTip(6);
        System.out.println(p1.tip);

        bankAccount myAcc = new bankAccount();
        myAcc.username = "Ayush Singh";
        // myAcc.password = "abcdjir";  //cant access private access haiye
        myAcc.setPassword("abcdefg");

    }
    
}
//dusre classes 
class pen{
     // Properties
      String color;
      int tip;

      //functions
      void setColor(String newColor){
        color = newColor;
    }
      void setTip(int newTip){
        tip= newTip;
      }

}
//acces modifier concept
class bankAccount{
    public String username;
    private String password;
    public void  setPassword(String pwd){
            password=pwd;
    }
}