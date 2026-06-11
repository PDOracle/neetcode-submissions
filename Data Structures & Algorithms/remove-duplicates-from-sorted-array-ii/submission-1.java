class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;
        int index = 0;
        int count = 0;
        while(r < nums.length){
            if(nums[r] == nums[l]){
                if(count < 2){
                    count++;
                    nums[index] = nums[r];
                    index++;
                }
            }
            else{
                count = 1;
                nums[index] = nums[r];
                l = r;
                index++;
            }
            r++;

        }
        return index;
    }
}