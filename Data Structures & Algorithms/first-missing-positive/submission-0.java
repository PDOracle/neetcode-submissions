class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                nums[i] = 0;
            }
        }

        for(int j = 0; j < n; j++){
            int val = Math.abs(nums[j]);
            if(1 <= val && val <= n){
                if(nums[val - 1] > 0){
                    nums[val - 1] *= -1;
                }
                else if(nums[val - 1] == 0){
                    nums[val - 1] = -1 * (n + 1);
                }
            }
        }

        for(int k = 1; k <= n; k++){
            if(nums[k - 1] >= 0){
                return k;
            }
        }
        return n + 1;
    }
}