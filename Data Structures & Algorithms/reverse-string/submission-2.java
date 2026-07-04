class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        char storage;
        while(l < r){
            storage = s[r];
            s[r] = s[l];
            s[l] = storage;
            l++;
            r--;
        }
    }
}