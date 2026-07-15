class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int res = 0;

        for(int num : nums){
            l = Math.max(l, num);
            r += num;
        }
        res = r;

        while(l <= r) {
            int m = l + (r - l) / 2;
            if(split(nums, k, m)){
                res = m;
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return res;
    }

    public boolean split(int[] nums, int k, int largest){
        int subarray = 1;
        int currSum = 0;
        for(int num : nums){
            currSum += num;
            if(currSum > largest) {
                subarray++;
                if(subarray > k) return false;
                currSum = num;
            }
        }
        return true;
    }
}