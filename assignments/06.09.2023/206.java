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
    public ListNode reverseList(ListNode head) {
        ListNode dup = null;

        ListNode curr = head;

        ListNode next = new ListNode(0);

        while(curr != null){
            next = curr.next;
            curr.next = dup;

            dup = curr;
            curr = next;
        }

        return dup;
    }
}