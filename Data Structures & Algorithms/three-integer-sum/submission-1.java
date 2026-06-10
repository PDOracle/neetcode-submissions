class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> trios = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int target = nums[i];
            if(i > 0 && target == nums[i-1]){
                continue;
            }
            if(target > 0){
                break;
            }
            int l = i+1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[l] + nums[r] + target;
                if(sum > 0){
                    r--;
                }
                else if(sum < 0){
                    l++;
                }
                else{
                    trios.add(Arrays.asList(target, nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                }

            }

        }
        return trios;
    }
}
