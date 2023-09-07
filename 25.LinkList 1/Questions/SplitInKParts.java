// Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

// The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

// The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

// Return an array of the k parts.

// Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
// Output: [[1,2,3,4],[5,6,7],[8,9,10]]
// Explanation:
// The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.



class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int N = 0 ; //size
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            N++;
        }

        ListNode prev = null;
        ListNode curr = head;

        int eachBukNode = N/k; //each bucket node
        int remNode = N%k ; // node remaining
        for(int i = 0 ; curr != null && i < k ; i++){
            ans[i] = curr;
            for(int j = 0 ; j < eachBukNode + (remNode > 0 ? 1 : 0) ; j++){
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            remNode--;
        }
        return ans;
    }
}