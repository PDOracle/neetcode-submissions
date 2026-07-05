class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackStack = new Stack<>();
        for(char brack: s.toCharArray()){
            if(brack == '(' || brack == '{' || brack == '['){
                brackStack.add(brack);
            }
            else if(brackStack.isEmpty()){
                return false;
            }
            else if(brack == ')'){
                if(brackStack.peek() == '('){
                    brackStack.pop();
                }
                else{
                    return false;
                }
            }
            else if(brack == '}'){
                if(brackStack.peek() == '{'){
                    brackStack.pop();
                }
                else{
                    return false;
                }
            }
            else if(brack == ']'){
                if(brackStack.peek() == '['){
                    brackStack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return brackStack.isEmpty();
    }
}
