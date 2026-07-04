class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int point1 = 0;
        int point2 = 0;
        while(point2 < n){
            if(nums1[point1] == 0 && point1 >= m){
                nums1[point1] = nums2[point2];
                point2++;
            }
            else if(nums2[point2] <= nums1[point1]){
                for(int i = m+n-1; i > point1; i--){
                    nums1[i] = nums1[i-1];
                }
                nums1[point1] = nums2[point2];
                point2++;
            }
            point1++;
        }
    }
}