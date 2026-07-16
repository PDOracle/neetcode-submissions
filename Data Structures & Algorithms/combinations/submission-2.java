class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        comb(1, n, k, new ArrayList<>());
        return res;
    }

    public void comb(int start, int n, int k, List<Integer> arr){
        if(start > n){
            if(k == arr.size()){
                res.add(new ArrayList<>(arr));
            }
            return;
        }

        arr.add(start);
        comb(start + 1, n, k, arr);
        arr.remove(arr.size() - 1);
        comb(start + 1, n, k, arr);
    }
}