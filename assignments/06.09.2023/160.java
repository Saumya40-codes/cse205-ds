/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /*

same as a prev approach of explicitly counting but this time, lets say the smaller LL is a and b is otherwise then, while traversing the point at which a == null the difference in position will be the difference in the length of each of them. now to get to the position where both of remaining length to be traverse becomes equal, when a == null, we point a to headB and vice versa and while doing this after certain itteration both will be at common starting point before intersection

as a will be covering same extra distance that b covers before b points to a's head

 */

 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            if(a == null){
                a = headB;
            }
            else{
                a = a.next;
            }

            if(b == null){
                b = headA;
            }
            else{
                b = b.next;
            }
        }

        return a;
    }
}

/*

prev:

    if size of both of the LL becomes equal then they will be having same intersection point (if they have one)

        int a = 0;
        int b = 0;

        ListNode dum1 = headA;
        ListNode dum2 = headB;

        while(dum1 != null){
            a++;
            dum1 = dum1.next;
        }

        while(dum2 != null){
            b++;
            dum2 = dum2.next;
        }

        int limit = Math.max(a,b) - Math.min(b,a);

        ListNode itter = new ListNode();
        ListNode small = new ListNode();

        if(a > b){
            itter = headA;
            small = headB;
        }
        else{
            itter = headB;
            small = headA;
        }

        // System.out.println(limit + " " + itter.val + " " + small.val);

        while(itter != null && limit != 0){
            itter = itter.next;
            limit--;
        }

        while(itter != null && small != null){

            if(itter == small){
                return itter;
            }

            itter = itter.next;
            small = small.next;
        }

        return null;

*/