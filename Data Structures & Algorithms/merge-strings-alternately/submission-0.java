class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder(word1.length() + word2.length());
        int shortLength = Math.min(word1.length(), word2.length());
        for(int i = 0; i < shortLength; i++){
            mergedString.append(word1.charAt(i));
            mergedString.append(word2.charAt(i));
        }
        if(word1.length() > word2.length()){
            mergedString.append(word1.substring(word2.length()));
        }
        else if(word1.length() < word2.length()){
            mergedString.append(word2.substring(word1.length()));
        }
        return mergedString.toString();
    }
}