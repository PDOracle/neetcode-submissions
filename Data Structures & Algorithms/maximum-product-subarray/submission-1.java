class Solution {
    private int[] dpPos;
    private int[] dpNeg;
    private int[] dp;
    public int maxProduct(int[] nums) {
        dpPos = new int[nums.length + 1];
        dpNeg = new int[nums.length + 1];
        dp = new int[nums.length];

        //Arrays.fill(dpPos, -1);
        //Arrays.fill(dpNeg, 1);
        dpNeg[nums.length] = 1;
        dpPos[nums.length] = 1;

        return dfs(nums, 0);

    }

    public int dfs(int[] nums, int index){

        if(index == nums.length){
            return Integer.MIN_VALUE;
        }
        int res = dfs(nums, index + 1);
        if(nums[index] == 0){
            dpPos[index] = 0;
            dpNeg[index] = 0;
        }

        else if(nums[index] > 0){
            dpPos[index] = Math.max(nums[index], nums[index] * dpPos[index + 1]);
            dpNeg[index] = nums[index] * dpNeg[index + 1];
        }

        else if(nums[index] < 0){
            dpPos[index] = nums[index] * dpNeg[index + 1];
            dpNeg[index] = Math.min(nums[index], nums[index] * dpPos[index + 1]);
        }

        dp[index] = Math.max(res, dpPos[index]);
        return dp[index];
    }
}
