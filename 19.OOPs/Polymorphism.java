public class Polymorphism{
    public static void main(String[] args) {
        Calcululator calc = new Calcululator();
        System.out.println(calc.sum(2, 4));
        System.out.println(calc.sum((float)1.5, (float)2.9));
        System.out.println(calc.sum(2,4 ,8 ));

        Dog teddy = new Dog();
        teddy.eat();  //it will prefer the funtion of child(or its own) class function
        Animal d1 =new Animal();
        d1.eat();
    }
}

//funtion Overloading
class Calcululator{  
    int sum(int a, int b){
        return a+b;
    }

    float sum(float a, float b){
        return a+b;
    }
    int sum(int a, int b, int c){
        return a+b+c;
    }
}

//Function Over riding
class Animal{
    void eat(){
        System.out.println("Eats anything");
    }
}
class Dog extends Animal{
    void eat(){
        System.out.println("Eats pedigree");
    }
}