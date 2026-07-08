class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] arr, int l, int r){
        if(l < r){ //BC, otherwise we have recursed to single index range and are done
            int part = partition(arr, l, r);
            quickSort(arr, 0, part - 1);
            quickSort(arr, part + 1, r);
        }
    }

    public int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i = l - 1; //holds last index of values smaller than pivot(-1 from the partition return index)

        for(int j = l; j < r; j++){ //we only care about going to values up to but not including the pivot
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
            
        }

        swap(arr, i + 1, r);
        return i + 1;
    }

    public void swap(int[] arr, int l, int r){
        int stor = arr[l];
        arr[l] = arr[r];
        arr[r] = stor;
    }
}