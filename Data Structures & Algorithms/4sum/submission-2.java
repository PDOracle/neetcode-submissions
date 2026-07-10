class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int smallSeen = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 3; i++){
            if(smallSeen < nums[i]){
                smallSeen = nums[i];
                int smallSeenTwo = Integer.MIN_VALUE;
                for(int j = i + 1; j < nums.length - 2; j++){
                    if(smallSeenTwo >= nums[j]){
                        continue;
                    }
                    smallSeenTwo = nums[j];
                    long remTarget =(long) target - nums[i] - nums[j];
                    int l = j + 1;
                    int r = nums.length - 1;
                    while(l < r){
                        if(j + 1 < l){
                            if(l < r && nums[l-1] == nums[l]){
                                l++;
                                continue;
                            }
                        }
                        if(r < nums.length - 1){
                            if(l < r && nums[r] == nums[r + 1]){
                                r--;
                                continue;
                            }
                        }

                        if(nums[l] + nums[r] == remTarget){
                            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            l++;
                            r--;
                        }
                        else if(nums[l] + nums[r] < remTarget){
                            l++;
                            continue;
                        }
                        else{
                            r--;
                            continue;
                        }
                        
                    }
                }
            }
        }
        return res;
    }   
}