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
    private static ListNode sort(ListNode low, ListNode high ){
        ListNode temp = new ListNode();
        ListNode curr = temp;


        while(low != null && high != null){
            if(low.val <= high.val){
                curr.next = new ListNode(low.val);
                low  = low.next;
            }
            else{
                curr.next = new ListNode(high.val);
                high  = high.next;
            }

            curr = curr.next;
        }

        if(low != null) curr.next = low;
        if(high != null) curr.next = high;

        return temp.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode low = sortList(head);
        ListNode high = sortList(slow);

        return sort(low,high);
    }
}