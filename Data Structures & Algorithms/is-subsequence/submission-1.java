class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPoint = 0;
        int tPoint = 0;

        while(sPoint < s.length() && tPoint < t.length()){
            if(t.charAt(tPoint) == s.charAt(sPoint)){
                sPoint++;
            }
            tPoint++;
        }
        return sPoint == s.length();
    }
}