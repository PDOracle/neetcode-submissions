class Solution {
    
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        int val = n;
        int sum = 0;
        while(true){
            while(val != 0){
                sum += Math.pow(val % 10, 2);
                val /= 10;
            }
            if(sum == 1){
                return true;
            }
            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            val = sum;
            sum = 0;
        }  
    }
}
