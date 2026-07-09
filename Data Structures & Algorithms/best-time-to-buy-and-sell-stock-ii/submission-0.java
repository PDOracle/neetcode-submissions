class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return dp(prices, 0, 0, dp);
    }

    public int dp(int[] prices, int index, int bought, int[][] dp){
        if(index == prices.length){
            return 0;
        }

        if(dp[index][bought] != -1){
            return dp[index][bought];
        }

        int res = dp(prices, index + 1, bought, dp);

        if(bought == 1){
            res = Math.max(res, prices[index] + dp(prices, index + 1, 0, dp));
        }
        else{
            res = Math.max(res, -prices[index] + dp(prices, index + 1, 1, dp));
        }

        dp[index][bought] = res;
        return res;
    }
}