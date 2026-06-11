class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }

        int largestSequence = 0;
        int offset = 1;
        for(int num: nums){
            if(numSet.contains(num-1)){
                continue;
            }
            offset = 1;
            while(true){
                if(!numSet.contains(num + offset)){
                    largestSequence = Math.max(largestSequence, offset);
                    break;
                }
                offset += 1;
            }
        }
        return largestSequence;
    }
}
