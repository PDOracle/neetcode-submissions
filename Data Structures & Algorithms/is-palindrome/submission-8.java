class Solution {
    public boolean isPalindrome(String s) {
        String lowerS = s.toLowerCase();
        lowerS = lowerS.replaceAll(
          "[^a-zA-Z0-9]", "");
        int l = 0, r = lowerS.length() - 1;
        while(l < r){
            if(lowerS.charAt(l) != lowerS.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
