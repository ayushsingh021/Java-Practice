// Given a linked list, you have to perform the following task:

// Extract the alternative nodes starting from second node.
// Reverse the extracted list.
// Append the extracted list at the end of the original list.
// Note: Try to solve the problem without using any extra memory.

// Example 1:

// Input:
// LinkedList = 10->4->9->1->3->5->9->4
// Output: 
// 10 9 3 9 4 5 1 4
// Explanation: 
// Alternative nodes in the given linked list are 4,1,5,4. Reversing the alternative nodes from the given list, and then appending them to the end of the list results in a list 10->9->3->9->4->5->1->4.



class Solution
{   
    public static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null){
            
            next = curr.next;
            curr.next = prev;
            prev =curr;
            curr =next;
        }
        
        return prev;
    }
    public static void rearrange(Node odd)
    {
        Node head = odd; //to remember the point
        Node even = odd.next;
        Node evenHead = even; //to remember the point
        
        while(even != null && even.next != null){
            //breaking the connections
            odd.next = odd.next.next;
            even.next = even.next.next;
            //moving pointer
            odd = odd.next;
            even = even.next;
        }
        Node reverseNode = reverse(evenHead);
        odd.next = reverseNode;
    }
}
