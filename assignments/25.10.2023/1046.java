class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i =0 ; i < stones.length ; i++){
            queue.offer(stones[i]);
        }
        while(queue.size() > 1){
            int dif = Math.abs(queue.poll() - queue.poll());
            if(dif != 0){
                queue.offer(dif);
            }
        }
        if(queue.size() > 0){
            return queue.poll();
        }
        return 0;
    }
}