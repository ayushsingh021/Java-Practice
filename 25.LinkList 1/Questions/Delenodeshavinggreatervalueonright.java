// Given a singly linked list, remove all the nodes in the list which have any node on their right whose value is greater. (Not just immidiate Right , but entire List on the Right)

 

// Example 1:

// Input:
// LinkedList = 12->15->10->11->5->6->2->3
// Output: 15 11 6 3
// Explanation: Since, 12, 10, 5 and 2 are
// the elements which have greater elements
// on the following nodes. So, after deleting
// them, the linked list would like be 15,
// 11, 6, 3.

class Solution
{   
    public static Node reverseLL(Node root){
        Node prev = null;
        Node curr = root;
        Node next;
        
        while(curr != null){
            next = curr.next;
            curr.next= prev;
            prev = curr;
            curr= next;
        }
        root = prev;
        
        return prev;
    }
    Node compute(Node head)
    {
       head = reverseLL(head);
       Node dummy = new Node(head.data);
       Node ans = dummy; 
        
        Node right = head.next ;
         int curr = head.data;
      while(right != null  ){
         
      
          if(right.data >= curr){
              dummy.next  = new Node(right.data);
              dummy = dummy.next;
              curr = right.data;
          
          }
          right = right.next;
           
      }
       return reverseLL(ans);
    }
}