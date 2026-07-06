class Solution {
    public String addBinary(String a, String b) {
        StringBuilder bin = new StringBuilder();
        int carry = 0;
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        while(aLen >= 0 || bLen >= 0 || carry > 0){
            int digA = aLen >= 0 ? a.charAt(aLen) - '0' : 0;
            int digB = bLen >= 0 ? b.charAt(bLen) - '0' : 0;
            int total = digA + digB + carry;
            bin.append(total % 2);
            carry = total / 2;
            aLen--;
            bLen--;
        }
        return bin.reverse().toString(); //StringBuilder puts our digits at the end w/StringBuilder.append()), so we only need to flip once
    }
}