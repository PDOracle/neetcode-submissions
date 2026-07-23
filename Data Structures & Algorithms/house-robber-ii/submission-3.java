class Solution {
    private int[] dpTrue;
    private int[] dpFalse;

    public int rob(int[] nums) {
        dpTrue = new int[nums.length];
        dpFalse = new int[nums.length];
        Arrays.fill(dpTrue, -1);
        Arrays.fill(dpFalse, -1);

        dp(nums, nums.length - 1, false);
        return Math.max(dpTrue[nums.length - 1], dpFalse[nums.length - 1]);
    }

    public int dp(int[] nums, int house, boolean taken){
        if(house < 0){
            return 0;
        }
        if(house == 0){
            if(taken){
                return 0;
            }
            dpFalse[house] = nums[house];
            return dpFalse[house];
        }


        if(taken){
            if(dpTrue[house] != -1){
                return dpTrue[house];
            }
            dpTrue[house] = Math.max(nums[house] + dp(nums, house - 2, (house == nums.length - 1 || taken)), 
            dp(nums, house - 1, taken));
            return dpTrue[house];
        }
        if(dpFalse[house] != -1){
            return dpFalse[house];
        }
        dpFalse[house] = Math.max(nums[house] + dp(nums, house - 2, (house == nums.length - 1 || taken)), 
        dp(nums, house - 1, taken));
        return dpFalse[house];
    }
}
