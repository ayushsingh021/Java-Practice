public class absConsHierarcy {
    public static void main(String[] args) {
    Mustang myHorse =new Mustang();
    // Animal --> Horse -- > Mustang        
    }
}
abstract class Animal{
    Animal(){
        System.out.println("Animal constructor is called");
    }
    void eat(){
        System.out.println("Animal eats");
    }
    abstract void walk();
}
class Horse extends Animal{
    Horse(){
        System.out.println("Horse is called");
    }
    void walk(){
        System.out.println("Walks on 4 legs");
    }
}
class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang is called");
    }
}
