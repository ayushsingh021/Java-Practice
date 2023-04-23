import java.util.*;


public class mergeSortLL {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
         
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

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        
    }
    // public void print(){
    //     if(head == null){
    //         System.out.println("LL is empty");
    //         return;
    //     }
    //     Node temp = head;
    //     while(temp != null){
    //         System.out.println(temp.data + "->" +" ");
    //         temp = temp.next;
    //     }

    // }

    public static Node head;
    public static Node tail;    
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;  //+1
            fast = fast.next.next;  //+2
        }

        return slow;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node midNode = getMid(head);
       
        //left and right half head se mergesort
        Node rightHead = midNode.next;
        midNode.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //merging the sorted array
        return merge(newLeft , newRight);

    }
    public Node merge(Node head1 , Node head2){
        Node mergedLL = new Node(-1); //dummy node
        Node temp = mergedLL;

        while(head1 != null && head2 !=null){
            if(head1.data < head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;

    }
    public void zigZag() {
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
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        //1 - 2 -3 - 4  -5
        ll.print();
        ll.zigZag();
        // ll.head = ll.mergeSort(ll.head);
        ll.print();
    }
}
