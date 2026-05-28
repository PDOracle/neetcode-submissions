class Solution {
    public boolean hasDuplicate(int[] nums) {
        /*
        HashSet<Integer> uniques = new HashSet<Integer>();
        for(int num: nums){
            if(uniques.contains(num)){
                return true;
            }
            uniques.add(num);
        }
        return false;*/
        HashSet<Integer> uniques = new HashSet<Integer>();
        for(int num: nums){
            uniques.add(num);
        }
        return !(uniques.size() == nums.length); 
    }
}