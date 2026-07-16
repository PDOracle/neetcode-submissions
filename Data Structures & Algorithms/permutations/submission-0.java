class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return res;

    }

    public void backtrack(int[] nums, boolean[] picked, List<Integer> arr){
        if(arr.size() == nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!picked[i]){
                arr.add(nums[i]);
                picked[i] = true;
                backtrack(nums, picked, arr);
                arr.remove(arr.size() - 1);
                picked[i] = false;
            }
        }
    
    }
}
