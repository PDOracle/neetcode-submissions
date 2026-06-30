class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] step_min = new int[cost.length];
        return dp(cost.length, step_min, cost);
    }

    public int dp(int n, int[] step_cost, int[] cost){
        if(n < 0){
            return 0;
        }
        if(n <= 1){
            return step_cost[n];
        }
        if(step_cost[n-2] == 0){
            step_cost[n - 2] = cost[n-2] + dp(n - 2, step_cost, cost);
        }
        if(step_cost[n-1] == 0){
            step_cost[n - 1] = cost[n-1] + dp(n - 1, step_cost, cost);
        }
        return Math.min(step_cost[n - 1], step_cost[n - 2]);
    }
}
