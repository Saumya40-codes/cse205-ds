class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;

        for(int num: nums){

            int cnt = 0;

            int digit = num;

            while(digit != 0){
                digit /= 10;
                cnt++;
            }

            if(cnt % 2 == 0){
                ans++;
            }
        }

        return ans;

    }
}