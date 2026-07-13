class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<String> cStack = new Stack<>();
        //StringBuilder res = new StringBuilder();
        String res = "";
        int pointer = 0;
        String comp = "";

        while(pointer < s.length()){
            char c = s.charAt(pointer);
            if(c >= 'a' && c <= 'z'){
                if(stack.isEmpty()){
                    //res.append(c);
                    res += String.valueOf(c);
                }
                else{
                    comp += c;
                }
                pointer++;
            }
            else if(c == ']'){
                
                int loop = Integer.valueOf(stack.pop());
                String tmp = comp;
                for(int i = 1; i < loop; i++){
                    comp += tmp;
                }

                comp = cStack.pop() + comp;
                if(stack.isEmpty()){
                    //res.append(comp);
                    res += comp;
                    comp = "";
                }
        
                pointer++;
            }
            else{
                String num = "";
                while(c >= '0' && c <= '9'){
                    num += c;
                    pointer++;
                    c = s.charAt(pointer);
                }
                stack.push(num);
                cStack.push(comp);
                comp = "";
                pointer++;
            }
        }
        //return res.toString();
        return res;
    }
}