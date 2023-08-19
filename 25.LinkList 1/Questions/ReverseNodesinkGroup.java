// //VV IMP

// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
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

 //Approach 2 : appraoch of revesing ll
class Solution {
    public int length(ListNode head){
            ListNode temp = head;
            int len = 0;
            while(temp != null ){
                temp = temp.next;
                len++;
            }
            return len;
        }
    public  ListNode th = null;
    public  ListNode tt = null;
    public  void addFirstNode(ListNode node){
        if( th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode curr = head;
        int len = length(head);
        ListNode oh = null;
        ListNode ot = null;
        while(len >= k){
            int tempK = k;
            while(tempK-- > 0 ){
                ListNode forw = curr.next;
                curr.next = null ; //link break
                addFirstNode(curr);
                curr = forw;
            }
            if(oh == null){
                oh = th;
                ot = tt;
            }else{
                ot.next =th;
                ot= tt;
            }
            th = null;
            tt = null;
            len = len - k;
        }
        ot.next = curr;
        return oh;
    }
}