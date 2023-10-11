class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num: arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int lim = arr.length/2;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(map.get(b)-map.get(a)));
        pq.addAll(map.keySet());
        int cnt = 0;
        int max = arr.length;

        while(!pq.isEmpty()){
            int num = pq.poll();
            max -= map.get(num);

            if(max <= lim) break;
            else cnt++;
        }

        return cnt+1;
    }
}