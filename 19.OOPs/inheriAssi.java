public class inheriAssi {
    public static void main(String[] args) {
        peacock P1 = new peacock();
        P1.breathe();

    }
    
}
class Animal{
    String color;

    void eat(){
        System.out.println("Eats");
    }
    void breathe(){
        System.out.println("Breathes");
    }
}

class Fish extends Animal{
    void swim(){
        System.out.println("Swims");
    }
}
class Birds extends Animal{
    void fly(){
        System.out.println("Flies");
    }
}
class Mammals extends Animal{
    void walk(){
        System.out.println("Walks");
    }
}
class peacock extends Birds{
    void dance(){
        System.out.println("Dances");
    }
}
class parrot extends Birds{
    void color(){
        System.out.println("Green");
    }
}

