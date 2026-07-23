class Solution {
    private int dp[];
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);


        return dp(nums, nums.length - 1);
    }

    public int dp(int[] nums, int house) {
        if(house < 0){
            return 0;
        }

        if(dp[house] != -1){
            return dp[house];
        }

        dp[house] = Math.max(nums[house] + dp(nums, house - 2), dp(nums, house - 1));
        return dp[house];
    }
}
