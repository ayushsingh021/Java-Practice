// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
// Your code will only be given the head of the original linked list.

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // HashMap<Node,Node> hm = new HashMap<>();
        // Node temp = head;
        // //first iteration for creating newNode 
        // while(temp != null){
        //     Node newNode = new Node(temp.val);
        //     hm.put(temp,newNode);
        //     temp = temp.next;
        // }

        // Node t = head;
        // //2nd iteration for giving the values of the pointer
        // while(t != null){
        //     Node node = hm.get(t);
        //     if(t.next != null){
        //         node.next = hm.get(t.next);
        //     }else{
        //         node.next = null;
        //     }

        //     if(t.random != null){
        //         node.random = hm.get(t.random);
        //     }else{
        //         node.random = null;
        //     }
        // t= t.next;
        // }

        // return hm.get(head);
        

        // step1
        Node temp = head;
        while(temp!= null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        //step 2
        Node itr = head;
        while(itr != null){
            if(itr.random != null){
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }

        //step -3 
        Node dummy = new Node(0);
         itr = head;
         temp = dummy;
        Node fast;
        while(itr != null){
            fast = itr.next.next;
            temp.next = itr.next;
            itr.next = fast;
           temp = temp.next;
           itr = fast; 
        }
        return dummy.next;
    }
}