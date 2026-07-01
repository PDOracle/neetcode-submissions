class Solution {
    public int majorityElement(int[] nums) {
        int maj = 0;
        int maxCount = 0;
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for(int num: nums){
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            if(occurrences.get(num) > maxCount){
                maxCount = occurrences.get(num);
                maj = num;
            }
        }
        return maj;
    }
}