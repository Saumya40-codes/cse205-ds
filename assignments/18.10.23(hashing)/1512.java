class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int n: nums){
            ans += map.getOrDefault(n,0);
            map.put(n,map.getOrDefault(n,0)+1);
        }

        return ans;
    }
}