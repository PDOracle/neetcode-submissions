class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int integerBreak(int n) {
        return dfs(n);
    }
    public int dfs(int n){
        if(n == 0 || n == 1){
            return n;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        int finalRes = 0;
        for(int i = 1; i < (n / 2) + 1; i++){
            int res = Math.max(n - i, dfs(n - i));
            finalRes = Math.max(finalRes, i * res); 
        }
        dp.put(n, finalRes);
        return finalRes;
    }
}