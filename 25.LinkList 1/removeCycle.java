public class removeCycle {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data =data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void cycleRemove(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow =  slow.next;  //+1
            fast = fast.next.next; //+2
            if(slow == fast){
                cycle =  true; // cycle exist
                break;
            }
        }

        if(cycle == false){
            return;
        }
        //find the meeting point
        slow = head;
        Node prev =  null;
        while( slow != fast){
            prev =  fast;
            slow = slow.next; //+1
            fast = fast.next; //+2
        }
        // remove  cycle
        prev.next = null;

    }
    public static boolean isCycle(){
        Node slow = head;
        Node fast =  head;
        while(fast != null && fast.next != null){
            slow = slow.next;  //+1
            fast =  fast.next.next; //+2
            if(slow ==  fast){ //cycle exist
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList ll =  new LinkedList();
        head = new Node(1);
        Node temp = new Node(2);
        head.next =  temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1 - > 2 -> 3- >2
        System.out.println(isCycle());
        cycleRemove();
        System.out.println(isCycle());


    }
    
}
