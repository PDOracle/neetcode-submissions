class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum % k != 0){
            return false;
        }
        int targetSum = totalSum / k;
        Arrays.sort(nums);
        reverse(nums);

        return backtrack(nums, new int[k], 0, targetSum);
    }

    public boolean backtrack(int[] nums, int[] subsets, int index, int targetSum){
        if(index == nums.length){
            return true;
        }

        for(int k = 0; k < subsets.length; k++){
            if(subsets[k] + nums[index] <= targetSum){
                subsets[k] += nums[index];
                if(backtrack(nums, subsets, index + 1, targetSum)) return true;
                subsets[k] -= nums[index];
            }
            if(subsets[k] == 0){
                break;
            }
        }

        return false;
    }

    public void reverse(int[] nums){
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}