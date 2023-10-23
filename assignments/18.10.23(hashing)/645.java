class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int lim = nums[nums.length-1];

        HashMap<Integer,Integer> map = new HashMap<>();

        int rep = -1;
        int miss = -1;

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);

            if(map.get(num) >= 2){
                rep = num;
            }
        }

        for(int i = 1; i <= lim+1; i++){
            if(!map.containsKey(i)){
                miss = i;
                break;
            }
        }

        return new int[]{rep,miss};
    }
}