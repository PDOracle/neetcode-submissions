class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> opStack = new Stack<>();
        int tmpFirst;
        int tmpSecond;
        int score = 0;
        for(String op: operations){
            if(op.equals("+")){
                tmpFirst = opStack.pop();
                tmpSecond = opStack.peek() + tmpFirst;
                opStack.push(tmpFirst);
                opStack.push(tmpSecond);
                score += tmpSecond;
            }
            else if(op.equals("D")){
                opStack.push(opStack.peek() * 2);
                score += opStack.peek();
            }
            else if(op.equals("C")){
                score -= opStack.pop();
            }
            else{
                opStack.push(Integer.valueOf(op));
                score += Integer.valueOf(op);
            }
        }
        return score;
    }
}