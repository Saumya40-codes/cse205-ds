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
    public ListNode middleNode(ListNode head) {
        // ListNode curr = head;

        // int cnt = 0;

        // while(head != null){
        //     head = head.next;
        //     cnt++;
        // }

        // cnt = (cnt/2) + 1;

        // while(cnt > 1){
        //     curr = curr.next;
        //     cnt--;
        // }

        // return curr;
        

        // shifting one node 1 time while the another 2 times

       ListNode one = head;

       while(head != null && head.next != null){
           one = one.next;
           head = head.next.next;
       }

       return one;
    }
}