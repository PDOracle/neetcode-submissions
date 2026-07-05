class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        HashSet<Integer> candidates = new HashSet<>();

        for(int r = 0; r < nums.length; r++){
            
            if(r - l > k){
                candidates.remove(nums[l]);
                l++;
            }

            if(candidates.contains(nums[r])){
                return true;
            }
            candidates.add(nums[r]);

        }
        return false;
    }
}