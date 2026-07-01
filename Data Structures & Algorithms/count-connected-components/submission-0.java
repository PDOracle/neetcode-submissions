class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node){
        visited[node] = true;
        for(int n: adj.get(node)){
            if(!visited[n]){
                dfs(adj, visited, n);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj_list.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj_list.get(edge[0]).add(edge[1]);
            adj_list.get(edge[1]).add(edge[0]);
        }

        for(int j = 0; j < n; j++){
            if(!visited[j]){
                dfs(adj_list, visited, j);
                count++;
            }
        }
        return count;
    }
}
