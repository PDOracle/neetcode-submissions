class Solution {
    public int removeDuplicates(int[] nums) {
        /*
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
        */
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            if(nums[l] != nums[l+1]){
                l++;
            }
            else{
                for(int i = l; i < r; i++){
                    nums[i] = nums[i+1];
                }
                r--;
            }
        }
        return l + 1;

    }
}