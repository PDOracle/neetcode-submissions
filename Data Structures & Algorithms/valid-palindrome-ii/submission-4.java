class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return validPalindromeWithError(s, l, r-1) || validPalindromeWithError(s, l+1, r);
            }
            l++;
            r--; 
        }
        return true;
    }
    public boolean validPalindromeWithError(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}