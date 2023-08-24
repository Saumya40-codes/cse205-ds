class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;

        // approach 1

        // int buy = Integer.MAX_VALUE;
        // int profit = 0;

        // for(int price: prices){
        //     buy = Math.min(buy, price);
        //     profit = Math.max(profit, price-buy);
        // }

        // approach 2: same thing but with sliding window type approach

        int left = 0;
        int right = 1;

        while(right < prices.length){
            if(prices[left] > prices[right]){
                left = right;
            }

            else{
                profit = Math.max(profit, prices[right]-prices[left]);
            }

            right++;
        }

        return profit;
    }
}