class Solution {
    public int missingNumber(int[] nums) {
        // if(nums.length == 1){
        //     return nums[0] == 0?1:0;
        // }
    
        // Arrays.sort(nums);
        // if(nums[0] != 0) return 0;

        // int ans = -1;

        // for(int i = 0; i < nums.length-1; i++){
        //     if(nums[i+1]-nums[i] != 1){
        //         return nums[i]+1;
        //     }
        // }
        // return nums[nums.length-1]+1;

        int n = nums.length;
        int total = n*(n+1)/2;

        int curr = 0;
        for(int num: nums){
            curr += num;
        }

        return total-curr;
    }
}