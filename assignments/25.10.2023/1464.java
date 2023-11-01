class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int num:nums) q.offer(num);

        int n1 = q.poll();
        int n2 = q.poll();

        return (n1-1)*(n2-1);
    }
}