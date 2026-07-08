class Solution {
    public void sortColors(int[] nums) {
        int[] track = new int[3];
        for(int i = 0; i < nums.length; i++){
            track[nums[i]]++;
        } 
        int j = 0;
        for(int k = 0; k < track.length; k++){
            while(track[k] > 0){
                nums[j] = k;
                j++;
                track[k]--;
            }
        }
    }
}