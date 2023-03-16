public class Inheritence {
        public static void main(String[] args) {
            // Dog doberman = new Dog();
            // doberman.breathe();
            // doberman.legs = 4;
            // System.out.println(doberman.legs);  
            
            Birds parrot = new Birds();
            parrot.breathe();
            parrot.fly();
        }    
}

//Base class
class Animal{
    String color;

    void eat(){
        System.out.println("Eats");
    }
    void breathe(){
        System.out.println("Breathes");
    }
}
//Derived class/Subclass
// class Fish extends Animal{
//     int fins;

//     void swin(){
//         System.out.println("Swims");
//     }
// }

//Multi-level Inheritance
// class Mammals extends Animal{
//     int legs;
// }
// class Dog extends Mammals{
//     String breed;
// }

//Hierarchial Inheritance
class Mammals extends Animal{
    void walk(){
        System.out.println("Walks");
    }
}
class Birds extends Animal{
    void fly(){
        System.out.println("Flies");
    }
}
class Fish extends Animal{
    void swim(){
        System.out.println("Swims");
    }
}