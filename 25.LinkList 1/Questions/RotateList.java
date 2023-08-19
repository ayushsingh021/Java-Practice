// Given the head of a linked list, rotate the list to the right by k places.
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
          return head;
        }
        //brute
        // while(k-- > 0){  
        //   ListNode temp = head;
        //     while(temp.next.next != null){
        //     temp = temp.next;
        //      }    
        //   // ListNode prev = temp;
        //   ListNode forw = temp.next;
        //    temp.next = null;
        //    forw.next = head;
        //    head = forw;
        // }
        ListNode temp = head;
        int size = 1 ;
        while(temp.next != null){
          temp = temp.next;
          size++;
        }
        //circularing LL
        temp.next = head;
        k = k%size;
        int end = size - k;
        while(end-- != 0){
            temp = temp.next;
             head = temp.next;
        }
            temp.next = null;

        return head;
     
    }
}