public class multipleInheri {
    public static void main(String[] args) {
    Beer poo = new Beer();
    poo.eats();       
    poo.walks(); 
    }
}
interface carnivore{
    void eats(); 
}
interface herbivore{
    void walks();
}
class Beer implements carnivore,herbivore{
    public void eats(){
        System.out.println("eats both");
    }
    public void walks(){
        System.out.println("walks gently");
    }
}