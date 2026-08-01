class Solution {
    private Map<Integer, Integer> memo;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new HashMap<>();
        memo.put(0, 1);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int remaining){
        if(memo.containsKey(remaining)){
            return memo.get(remaining);
        }
        int res = 0;
        for (int num: nums){
            if(remaining < num) {
                break;
            }
            res += dfs(nums, remaining - num);
        }
        memo.put(remaining, res);
        return res;
    }
}