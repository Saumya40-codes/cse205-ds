class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num:hand) pq.offer(num);

        while(!pq.isEmpty()){
            int num = pq.poll();
            
            // int size = groupSize;

            for(int k = 1; k < groupSize; k++){
                if(pq.isEmpty() || !pq.contains(num+k)) return false;
                pq.remove(num+k);
            }
        }

        return true;
    }
}