class Solution {
    private boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()];
        Arrays.fill(dp, true);
        Set<String> words = new HashSet<>(wordDict);
        return dfs(s, words, 0);
    }

    public boolean dfs(String s, Set<String> words, int index){

        boolean res = false;
        if(index == s.length()){
            return true;
        }

        if(dp[index] == false){
            return false;
        }

        for(int i = 1; i <= s.length() - index; i++){
            String word = s.substring(index, index + i);
            if(words.contains(word)){
                dp[index] = dfs(s, words, index + i);
                res = res || dp[index];
                if(res){
                    break;
                }
            }
        }

        return res;
    }


}
