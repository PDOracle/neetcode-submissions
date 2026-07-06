class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> candidates = new HashSet<>();
        for(int i = 1; i < n + 1; i++){
            candidates.add(i);
        }
        int[][] adj = new int[n][n];

        for(int i = 0; i < trust.length; i++){
            adj[trust[i][0] - 1][trust[i][1] - 1] = 1;
            candidates.remove(trust[i][0]);
        }
       
        if(candidates.size() == 1){
            for(Integer c: candidates){
                for(int j = 0; j < adj.length; j++){
                    if(adj[j][c-1] == 0 && j != c - 1){
                        return -1;
                    }
                }
                return c;
            }
        } 
        return -1;
    }
}