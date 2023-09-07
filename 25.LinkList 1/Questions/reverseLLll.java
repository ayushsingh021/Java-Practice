// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

// Example 1:


// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
// Example 2:

// Input: head = [5], left = 1, right = 1
// Output: [5]

lass Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next= head;
        ListNode prev =  dummy ;
        for(int i = 1 ; i < left ; i++){
            prev = prev.next;
        }

        ListNode curr  =prev.next;
        for(int i = 1 ; i <= right-left ; i++){
            ListNode temp = prev.next; 
            prev.next =curr.next;
            curr.next = curr.next.next;
            prev.next.next =temp;
        }

    return dummy.next;

    }
}