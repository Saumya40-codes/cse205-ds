class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int l1_value = 0;
            int l2_value = 0;

            if (l1 != null) {
                l1_value = l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                l2_value = l2.val;
                l2 = l2.next;
            }

            int total = l1_value + l2_value + carry;
            curr.next = new ListNode(total % 10);
            carry = total / 10;
            curr = curr.next;
        }

        return head.next;
    }
}
