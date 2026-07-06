class Solution {
    public int reverseBits(int n) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 32; i++){
            int digit = ((1 << i) & n) != 0 ? 1 : 0;
            res.append(String.valueOf(digit));
        }
        return Integer.parseUnsignedInt(res.toString(), 2);
    }
}
