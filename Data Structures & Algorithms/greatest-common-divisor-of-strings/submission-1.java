class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int g = gcd(str1.length(), str2.length());
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str1.charAt(i % g)){
                return "";
            }
        }
        for(int j = 0; j < str2.length(); j++){
            if(str2.charAt(j) != str1.charAt(j % g)){
                return "";
            }
        }
        return str1.substring(0, g);
    }  

    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}