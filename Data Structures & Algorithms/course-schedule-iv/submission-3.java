class Solution {
    private List<Integer>[] adj;
    private int[][] preReqMemo;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new ArrayList[numCourses];
        preReqMemo = new int[numCourses][numCourses];
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
            Arrays.fill(preReqMemo[i], -1);
        }
        for(int[] list : prerequisites){
            adj[list[0]].add(list[1]);
            preReqMemo[list[0]][list[1]] = 1;
        }
        
        for(int[] query : queries){
            res.add(checkPrereq(query[0], query[1]));
        }

        return res;
    }

    public Boolean checkPrereq(int curr, int target){
        if(preReqMemo[curr][target] != -1){
            return preReqMemo[curr][target] == 1;
        }

        for(int pre : adj[curr]){
            if(pre == target || checkPrereq(pre, target)){
                preReqMemo[curr][target] = 1;
                return true;
            }
        }
        preReqMemo[curr][target] = 0;
        return false;
    }
}