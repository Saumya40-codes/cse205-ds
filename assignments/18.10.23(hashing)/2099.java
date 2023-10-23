class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] arr = new int[nums.length][2];   

        for(int i =0; i < nums.length; i++){
            arr[i] = new int[]{i,nums[i]};
        }

        Arrays.sort(arr,Comparator.comparingInt(a -> -a[1]));

        int[][] temp = Arrays.copyOf(arr,k);

        Arrays.sort(temp,Comparator.comparingInt(a->a[0]));

        int[] ans = new int[k];

        for(int i = 0; i < k; i++){
            ans[i] = temp[i][1];
        }

        return ans;
    }
}