class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int total = 0;
        int res = Integer.MAX_VALUE;
        while(r < nums.length){
            total += nums[r];
            if(total >= target){
                while(total - nums[l] >= target){
                    total -= nums[l];
                    l++;
                }
                res = Math.min(res, r - l + 1);
            }
            r++;
        }
        if(total < target){
            return 0;
        }
        return res;
    }
}