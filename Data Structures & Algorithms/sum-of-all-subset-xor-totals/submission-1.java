class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXOR(nums, 0, 0);
    }
    public int subsetXOR(int[] nums, int index, int total){
        if(index == nums.length){
            return total;
        }
        return subsetXOR(nums, index + 1, total) + subsetXOR(nums, index + 1, total ^ nums[index]);
    }
}