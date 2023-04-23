import java.util.*;
public class palindrome {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static int size;
    public static Node head;
    public static Node tail;
    public void addLast(int data){
        //create new node
        Node newNode = new Node(data);
        size++;
        //special case
        if(head == null){
            head = tail = newNode;
            return;
        }
        //link
        tail.next = newNode;
        tail = newNode;
    }
    public void print(){
        //special case
        if( head== null){
            System.out.println("the LL is empty");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

    }
    //slow-fast method
    public Node findMid(Node head){ //helper
        Node slow = head;
        Node fast = head;
        //fast == null (even size) // fast.next == null (odd size)
        while(fast != null  && fast.next != null){
            slow = slow.next; //+1 
            fast = fast.next.next; // +2
        }
        return slow ; //slow is the midNode

    }

    public boolean cheakPalindrome(Node head){
        //corner case
        if(head == null || head.next == null){
            return true;
        }
        //step 1: find midNode
        Node midNode = findMid(head);
        //step2 : reverse left half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }

        Node right = prev; // right half head
        Node left = head; //left half head
        //step 3 : lefthalf== righthalf
        while( right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        // ll.cheakPalindrome();
        System.out.println(ll.cheakPalindrome());
    }
    
}
