class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> occ = new HashMap<>();
        List<Integer> maj = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            occ.put(nums[i], occ.getOrDefault(nums[i], 0) + 1);
        }
        for(Integer i: occ.keySet()){
            if(occ.get(i) > len / 3){
                maj.add(i);
            }
        }
        return maj;
    }
}