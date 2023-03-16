public class GetSet {
    public static void main(String[] args) {
        Pen  p1 = new Pen(); //ye humne ek object bana dia 'p1' --> pen class me
        p1.setColor("Red"); // we accesssed 
        System.out.println(p1.getColor());
        p1.setColor("yellow");//we can directly access the prop. instead of funcction
        System.out.println(p1.getColor());
        p1.setTip(6);
        System.out.println(p1.getTip());
    }
    
}
class Pen{
        // Properties
        private String color;
        private int tip;
         //Getters
        String getColor(){
            return this.color;
         }
         int getTip(){
            return this.tip;
         } 
         //functions  /**Setters */
         void setColor(String newColor){
           color = newColor;
       }
         void setTip(int newTip){
           tip= newTip;
         }
   

}
