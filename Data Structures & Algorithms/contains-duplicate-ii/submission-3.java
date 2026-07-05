class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        int r = 1;

        while(l < nums.length){
            while(Math.abs(r - l) <= k && r < nums.length){
                if(nums[l] == nums[r]){
                    return true;
                }
                r++;

            }
            l++;
            r = l + 1;

        }
        return false;


    }
}