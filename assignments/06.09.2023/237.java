/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val ;
        node.next = node.next.next;
    }
}

// copy the next node value to the current node
// now shift the next pointer of the current node to the next of the next node 