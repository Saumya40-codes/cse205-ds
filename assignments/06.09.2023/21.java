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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         if(list1 == null){
             return list2;
         }

         if(list2 == null){
             return list1;
         }

         ListNode l1 = list1;
         ListNode l2 = list2;

         //  l1 point to smallest node

         if(l1.val > l2.val){
             ListNode temp = l1;
             l1 = l2;
             l2 = temp;
         }

         ListNode ans = l1;

         while(l1 != null && l2 != null){
             ListNode temp = null;

             while(l1 != null && l1.val <= l2.val){
                 temp = l1;
                 l1 = l1.next;
             }

             temp.next = l2;

             ListNode dup = l1;
             l1 = l2;
             l2 = dup;
         }

         return ans;
    }
}

/*

inplace swapping/traversal

temp will keep the track of latest smallest node so that if l1 > l2 we can do temp.next = l2;

keeping l1 be the smallest node and ans pointing to it

*/