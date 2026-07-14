class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        while(l < r){
            int m = l + (r - l) / 2;
            int diff = x - arr[m];
            if(diff <= 0){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        
        int l2 = l - 1;
        int r2 = l2 + 1;
        while(r2 - l2 - 1 < k){
            if(l2 < 0){
                r2++;
            }
            else if(r2 > arr.length - 1){
                l2--;
            }
            else if(Math.abs(x - arr[l2]) <= Math.abs(x - arr[r2])){
                l2--;
            }
            else{
                r2++;
            }
        }

        for(int m = l2 + 1; m < r2; m++){
            res.add(arr[m]);
        }

        return res;


    }

}