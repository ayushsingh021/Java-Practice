
// Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

// Example 1:


// Input: head = [1,2,3,4]
// Output: [2,1,4,3]
// Example 2:


class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next= head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode nextPair;
        ListNode second;
        while(curr !=null && curr.next != null){
            //pointer store
            nextPair = curr.next.next;
            second = curr.next ;
            
            //swap
            second.next = curr;
            curr.next = nextPair;
            prev.next = second; //dummt pointint head;
            
            //update;
            prev = curr;
            curr =  nextPair;
            
        }
        
        return dummy.next;
    }
}