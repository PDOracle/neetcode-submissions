class Solution {
    private int[] sub;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length / 2; i++){
            int tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
        if(nums[0] > target){
            return false;
        }
        sub = new int[2];
        return backtrack(nums, 0, sub, target);   
    }

    public boolean backtrack(int[] nums, int index, int[] sub, int target){
        System.out.println(Arrays.toString(sub));
        if(index == nums.length){
            return sub[0] == sub[1];
        }
        for(int i = 0; i < 2; i++){
            if(sub[i] + nums[index] <= target){
                sub[i] += nums[index];
                boolean res = backtrack(nums, index + 1, sub, target);
                if(res){
                    return true;
                }
                sub[i] -= nums[index];
                if(sub[i] == 0){
                    break;
                }
            }
        }   
        return false;
    }
}
