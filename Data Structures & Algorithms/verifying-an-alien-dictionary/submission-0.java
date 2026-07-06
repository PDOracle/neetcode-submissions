class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> alphOrd = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            alphOrd.put(order.charAt(i), i);
        }

        for(int j = 0; j < words.length - 1; j++){
            String word1 = words[j];
            String word2 = words[j + 1];

            for(int k = 0; k < word1.length(); k++){
                if(k == word2.length()) return false;
                if(word1.charAt(k) != word2.charAt(k)){
                    if(alphOrd.get(word1.charAt(k)) > alphOrd.get(word2.charAt(k))){
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}