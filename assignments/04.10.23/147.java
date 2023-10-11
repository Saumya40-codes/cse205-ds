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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dup = new ListNode(0);
        ListNode curr = head;

        while(curr != null){

            ListNode temp = dup;

            while(temp.next != null && temp.next.val <= curr.val){
                temp = temp.next;
            }

            ListNode nex = curr.next;
            curr.next = temp.next;
            temp.next = curr;

            curr = nex;
        }

        return dup.next;
    }
}