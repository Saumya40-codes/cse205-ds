class Solution {
    public int[] buildArray(int[] nums) {
        int[] temp_num = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            temp_num[i] = nums[nums[i]];
        }
        return temp_num;
    }
}