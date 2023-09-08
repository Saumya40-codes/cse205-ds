/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;


        while(fast.next != null  && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){

                while(slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }

                return entry;
            }
        }
        return null;
    }
}

/*


approach:

initially its same as the detecting the collision

now lets say the distance from head to starting point of loop (just before it) is "D"

let the distance from starting point of loop to point where slow pointer collides with head be "K"

then fast pointer moves extra "n" cycles thus nC

therefore for slow, total distance is -> D + K
          for fast,                is -> D + K + nC

          then as fast moves twice as more as slow then

          fast = 2(slow)

          D + K + nC = 2*(D + K)

          nc = D + K

          therefore D = nC - k

          thus from starting "D" and "nC-k" from collision can be moved by 1 to reach the starting point of the loop
*/