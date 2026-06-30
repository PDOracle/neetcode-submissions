class Solution {
    public int climbStairs(int n) {
        int[] stair = new int[n + 1];
        return dp(n, stair);
    }
    public int dp(int n, int[] staircase){
        if(n <= 1){
            return 1;
        }
        if(staircase[n] != 0){
            return staircase[n];
        }
        staircase[n] = dp(n - 1, staircase) + dp(n - 2, staircase);
        return staircase[n];
    }
}