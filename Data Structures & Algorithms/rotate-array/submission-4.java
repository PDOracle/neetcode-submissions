class Solution {
    public void rotate(int[] nums, int k) {
        int rot = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rot - 1);
        reverse(nums, rot, nums.length - 1);        
        
    }

    public void reverse(int[] nums, int l, int r){
        while(l < r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}