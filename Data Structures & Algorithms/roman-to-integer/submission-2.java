class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romIn = new HashMap<>();
        romIn.put('I', 1);
        romIn.put('V', 5);
        romIn.put('X', 10);
        romIn.put('L', 50);
        romIn.put('C', 100);
        romIn.put('D', 500);
        romIn.put('M', 1000);
        int sum = 0;
        boolean sub = false;
        for(int i = s.length() - 1; i > -1; i--){
            if(sub){
                sub = false;
                sum -= romIn.get(s.charAt(i));
                continue;
            }
            if(i != 0){
                if(s.charAt(i) == 'V' || s.charAt(i) == 'X'){
                    if(s.charAt(i - 1) == 'I'){
                        sub = true;
                    }
                }
                else if(s.charAt(i) == 'L' || s.charAt(i) == 'C'){
                    if(s.charAt(i - 1) == 'X'){
                        sub = true;
                    }
                }
                else if(s.charAt(i) == 'D' || s.charAt(i) == 'M'){
                    if(s.charAt(i - 1) == 'C'){
                        sub = true;
                    }
                }
            }

            sum += romIn.get(s.charAt(i));
            
        }
        return sum;

    }
}