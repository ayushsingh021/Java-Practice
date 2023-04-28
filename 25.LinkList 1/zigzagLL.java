import java.util.*;
import java.util.LinkedList;
public class zigzagLL{ //idi class ke name pe hoga ll incase not using collection frameworks
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
         
    }
    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->" +" ");
            temp = temp.next;
        }

    }
   
    public static Node head;
    public static Node tail;   
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null ){
            head = tail = newNode;
            return;
        }
        
        newNode.next = head;
        head= newNode;
        
    }
    public static void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node midNode = slow;
        //2nd half reverse
        Node curr = midNode.next;
        midNode.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next  = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node leftHead = head;
        Node rightHead = prev;
        Node nextL , nextR;
        //alt. merging

        while(leftHead != null && rightHead != null){
            nextL = leftHead.next;
            leftHead.next =  rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;
            rightHead = nextR;
            leftHead = nextL;
        }

    }
   
    public static void main(String[] args) {
        zigzagLL ll = new zigzagLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        System.out.println();
        zigZag();
        ll.print();
    }
}





// Java Program to Demonstrate
// Implementation of LinkedList
// class
 
// // Importing required classes
// import java.util.*;
// import java.util.LinkedList;
 
// Main class
// public class newQues {
 
//     // Driver code
//     public static void main(String args[])
//     {
//         // Creating object of the
//         // class linked list
//         List<String> ll = new LinkedList<>();
 
//         // Adding elements to the linked list
//         ll.add("A");
//         ll.add("B");
//         ll.add("C");
//         ll.add("D");
//         ll.add(2, "E");
 
//         System.out.println(ll);
 
//         ll.remove("B");
//         ll.remove(3);
//         // ll.removeFirst();
//         // ll.removeLast();
 
//         System.out.println(ll);
//     }
// }