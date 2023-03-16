public class Interfaces {
    public static void main(String[] args) {
        King k1 = new King();
        k1.move();
        
    }
}
interface chessPlayer{
    void move();  //wihout implementation
}
class Queen implements chessPlayer{

    public void move(){
        System.out.println("up,down,left,right,daig in all drxn");
    }
}
class Rook implements chessPlayer{
    public void move(){
        System.out.println("moves diag");
    }
}
class King implements chessPlayer{
    public void move(){
        System.out.println("up,down,left,right moves 1 step");
    }
}