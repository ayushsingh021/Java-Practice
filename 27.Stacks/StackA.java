import java.util.LinkedList;

public class StackA {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }

    }


    static class Stack{
        static Node head = null;
        public static boolean isEmpty(){
            return head == null;
        }

        //push
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        //pop
        public static int  pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head= head.next;
            return top;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            return top;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();  //new object of stack class create karlia
        s.push(4);       
        s.push(5);       
        s.push(6);
        
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
