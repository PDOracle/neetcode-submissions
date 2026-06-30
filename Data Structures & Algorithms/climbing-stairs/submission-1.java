class Solution {
    public int[] stair = new int[46];
    public int climbStairs(int n) {
        return dp(n-1) + dp(n-2);
    }
    public int dp(int n){
        if(n < 0){
            return 0;
        }
        if(n == 0 || n == 1){
            return 1;
        }
        if(stair[n] != 0){
            return stair[n];
        }
        stair[n] = dp(n - 1) + dp(n - 2);
        return stair[n];
    }
}