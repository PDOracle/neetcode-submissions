class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, profit = 0;
        int highDay = 0;
        while(r < prices.length){
            if(prices[r] < prices[l]){
                profit = Math.max(highDay - prices[l], profit);
                l = r;
                highDay = 0;
            }
            highDay = Math.max(prices[r], highDay);
            r++;
        }
        profit = Math.max(highDay - prices[l], profit);
        return profit;
    }
}
