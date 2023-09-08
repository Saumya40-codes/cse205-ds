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
    public boolean isPalindrome(ListNode head) {

        // if no or only one element exists then palindrome exists
        if(head == null || head.next == null){
            return true;
        }

        // finding the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversing the second part of the linkedlist

        ListNode curr = slow.next;
        ListNode dup = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = dup;
            dup = curr;
            curr = next;
        }

        // if first and second part are same the LL is palindrome else not

        ListNode start = head;

        while(dup != null){
            if(start.val != dup.val){
                return false;
            }
            start = start.next;
            dup = dup.next;
        }

        return true;
    }
}


/*

approach: find the middle of LL (as we consider its palindrom thus, the second part will lie there)

reverse that part so that if its actually palindrome then it will match all the elements of the first part

*/