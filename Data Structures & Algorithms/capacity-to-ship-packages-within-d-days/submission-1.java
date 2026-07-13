class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] > l){
                l = weights[i];
            }
            r += weights[i];
        }
        if(days == 1){
            return r;
        }
        while(l < r){
            int target = l + (r - l) / 2;
            if(shipWithin(weights, days, target)){
                r = target;
            }
            else{
                l = target + 1;
            }
        }
        return l;
    }

    public boolean shipWithin(int[] weights, int days, int target){
        int ships = 0;
        int count = 0;
        int pointer = 0;
        while(pointer < weights.length){
            if(count + weights[pointer] <= target){
                count += weights[pointer];
            }
            else{
                ships++;
                count = weights[pointer];
            }
            pointer++;
        }
        if(ships + 1 > days){
            return false;
        }
        return true;
    }
}