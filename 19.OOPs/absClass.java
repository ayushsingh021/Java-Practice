public class absClass {
    public static void main(String[] args) {
    Lion leo = new Lion();
    leo.eat();
    leo.walk();
    Chicken chick = new Chicken();
    chick.eat();
    chick.walk();    
    }
}
abstract class Animal{
    void eat(){
        System.out.println("Animal eats");
    }
    abstract void walk();
}
class Lion extends Animal{
    void walk(){
        System.out.println("Walks on 4 legs");
    }
}
class Chicken extends Animal{
    void walk(){
        System.out.println("Walks on 2 legs");
    }
}