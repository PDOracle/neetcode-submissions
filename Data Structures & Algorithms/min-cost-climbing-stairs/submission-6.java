class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] step_dp = new int[cost.length];
        step_dp[0] = cost[0];
        step_dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++){
            step_dp[i] = Math.min(step_dp[i-1], step_dp[i-2]) + cost[i];
        }
        return Math.min(step_dp[cost.length-1], step_dp[cost.length-2]);
    }
}
