class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                if(s.charAt(l) == s.charAt(r-1) && s.charAt(l+1) == s.charAt(r)){
                    return validPalindromeWithError(s, l, r-1) || validPalindromeWithError(s, l+1, r);
                }
                else if(s.charAt(l) == s.charAt(r-1)){
                    return validPalindromeWithError(s, l, r-1);
                }
                else if(s.charAt(l+1) == s.charAt(r)){
                    return validPalindromeWithError(s, l+1, r);
                }
                else{
                    return false;
                }
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