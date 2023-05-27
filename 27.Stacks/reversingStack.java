import java.util.*;;

public class reversingStack {
    //the solution have extra memory occupency
    // public static Stack reverseStack(Stack<Integer> s){
    //      Stack<Integer> newS = new Stack<>();
    //     while(!s.isEmpty()){
    //         newS.push(s.pop());
    //     }
    //     return newS;
    // }

    public static void pushAtBottom(Stack<Integer> s , int data){
            //base
            if(s.isEmpty()){
                s.push(data);
                return;
            }

            int top =  s.pop();
            pushAtBottom(s,data);
            s.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        //base case
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // Stack <Integer> result = reverseStack(s);
        // while(!result.isEmpty()){
        //     System.out.println(result.pop());
        // }
        reverseStack(s);
        printStack(s);
    }
    
}
