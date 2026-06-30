class Solution {
    public int tribonacci(int n) {
        int[] trib_list = new int[n + 3];
        trib_list[0] = 0;
        trib_list[1] = 1;
        trib_list[2] = 1;
        return trib_dp(n, trib_list);
    }
    public int trib_dp(int n, int[] trib_list){
        if(n <= 2){
            return trib_list[n];
        }
        if(trib_list[n] != 0){
            return trib_list[n];
        }
        trib_list[n-3] = trib_dp(n-3, trib_list);
        trib_list[n-2] = trib_dp(n-2, trib_list);
        trib_list[n-1] = trib_dp(n-1, trib_list);
        trib_list[n] = trib_list[n-3] + trib_list[n-2] + trib_list[n-1];
        return trib_list[n];
    }
}