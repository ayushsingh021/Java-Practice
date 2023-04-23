import javax.print.event.PrintEvent;

public class LinkedList{

    public static class Node{
        int data;
        Node next;

    public Node(int data){
            this.data = data;
            this.next = null;

        }
    }
    public Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){

        //step1- create new Node
        Node newNode = new Node(data);
        size++; //toget LL size

        if(head == null){
            head = tail = newNode;
            return;
        }
        
        //newNode's next = head
        newNode.next = head; //link
        //step 3-- head  = newNode
        head = newNode; 
    }

    public void addLast(int data){
        //step1 -- create new LL
        Node newNode = new Node(data);
        size++; //toget LL size

        //special case
        if(head == null){
            head = tail = newNode; 
            return;
        }
        //step 2 : newNode's next points towards tail
        tail.next =  newNode;
        //step 3 : 
        tail = newNode;
    }
    public void add(int idx , int data){
        //special case ( in it we are trying to add new node at head)
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++; //toget LL size
        Node temp = head;
        int i = 0;
        while(i < idx -1){
            temp = temp.next;
            i++;
        }

        //i = idx - 1 ; temp -- >[prev]
        newNode.next = temp.next;
        temp.next = newNode;  
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){// same head and tail
            int val =head.data;
            head =tail = null;
            size = 0 ; // as remove hone ke badd size 0  ho jaiga
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            head = tail = null;
            size= 0 ;
            return val;
        }
        Node prev = head; //intiate prev node ko head se
        for(int  i =0 ; i<size-2 ;i++){
            prev = prev.next;
        }

        int val = prev.next.data; //taildata
        prev.next =null;
        tail = prev;
        size--;
        return val;
    }

    public void print(){
        //speacial case : empty LL
        if(head == null){
            System.out.println("The LL is empty");
            return;
        }

        Node temp  = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int itrSearch(int key){
        Node temp = head;
        int i=0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next; // age ki ref ki taraf point karta hai
            i++;
        }
        return -1;
    }
    public int helper(Node head , int key){ 
        //it is doing the main work of the recursive func
        //base case
        if(head==null){ //key not exist in ll
            return -1;
        }
        //kaam
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);   
        if(idx == -1){
            return -1;
        }
        return idx +1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        Node prev = null;
        Node curr =tail=head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev =curr;
            curr =next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int N){
        //calculate size
        int size = 0;
        Node temp = head ; 
        while(temp != null){
            temp = temp.next;
            size++;
        }

        //size- n
        int i = 1;
        int idxToFind = size - N;
        Node prev = head;
        while(i < idxToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // ll.print();
        ll.addFirst(2);
        // ll.print();
        ll.addFirst(1);
        // ll.print();

        ll.addLast(3);
        // ll.print();
        ll.addLast(4);
        ll.add(2, 9);   //call this methods at last for better results
        ll.print();
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        ll.reverse();
        ll.print();
        ll.deleteNthFromEnd(4);
        ll.print();
        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(9));
        // System.out.println(ll.size);
    
    }

    public char[] cheakPalindrome() {
        return null;
    }

    public void zigZag() {
    }
}