class Solution {
    private int score;
    public int subsetXORSum(int[] nums) {
        score = 0;
        subsetXOR(nums, 0, 0);
        return score;
    }
    public void subsetXOR(int[] nums, int index, int currXOR){
        if(index > nums.length - 1){
            score += currXOR;
            return;
        }

        subsetXOR(nums, index + 1, currXOR ^ nums[index]);
        subsetXOR(nums, index + 1, currXOR);

    }
}