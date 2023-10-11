class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->(map.get(b)-map.get(a)));
        pq.addAll(map.keySet());
        String res = "";

        while(!pq.isEmpty()){
            char c = pq.poll();

            int cnt = map.get(c);

            while(cnt-- > 0){
                res += c;
            }
        }

        return res;
    }
}