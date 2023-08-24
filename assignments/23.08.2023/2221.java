class Solution {
    public int triangularSum(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int[] arr = new int[nums.length-1];


        for(int i = 0; i < nums.length-1; i++){
            int sum = 0;
            sum = (nums[i] + nums[i+1]);

            if(sum < 10){
                arr[i] = sum;
            }
            
            else{
                arr[i] = (sum%10);
            }
        }

        return triangularSum(arr);
    }
}

/*

statement based solving, like in first itteration by doing what statement says we can get the array of
n-1 length now on recurssion we pass the same array, now array size 1 less thus on keep doing this we will
get the array size == 1 which will be the answer

*/