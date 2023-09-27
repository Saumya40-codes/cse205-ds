class MinStack {

    class ListNode{
        ListNode next;
        int val;
        int min;

        public ListNode(int val, int min, ListNode next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private ListNode stack;

    public MinStack() {
        stack = null;
    }
    
    public void push(int val) {
        if(stack == null){
            stack = new ListNode(val,val,null);
            return;
        }

        stack = new ListNode(val, Math.min(stack.min,val), stack);
    }
    
    public void pop() {
        stack = stack.next;
    }
    
    public int top() {
        return stack.val;
    }
    
    public int getMin() {
        return stack.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 // arraylist O(N) TC while getting the min else O(1)

 // LL -> O(1) overall

 /*

for e.g. if the elements are added in following way in stack 1->2->3->4->5
then during each push we assign new node next pointer to the current node

so it will be like 1 -> null // initially
then 2->1-> null and so on.. keeping track of min between current node and the node which is going to push
does helps because of LIFO and the min node wont get removed before the other node before that
 */