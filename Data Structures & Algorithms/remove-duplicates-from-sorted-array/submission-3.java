class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 1;
        int unique = 1;
        int duplicate = 0;
        while(r < nums.length && unique + duplicate != nums.length){
            if(nums[l] != nums[r]){
                unique++;
                l = r;
                r++;
            }
            else{
                duplicate++;
                for(int i = r; i < nums.length - 1; i++){
                    nums[i] = nums[i+1];
                }
            }
        }
        return unique;
    }
}