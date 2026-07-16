class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        comb(1, n, k, new ArrayList<>());
        return res;
    }

    public void comb(int start, int n, int k, List<Integer> arr){
        if(k == 0){
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i = start; i < n + 1; i++){
            arr.add(i);
            comb(i + 1, n, k - 1, arr);
            arr.remove(Integer.valueOf(i));
        }

        return;
    }
}