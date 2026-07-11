class FreqStack {
    private Stack<Integer> stack;
    private Stack<Integer> tmp;
    private int lFreq;
    private HashMap<Integer, Integer> freq;
    public FreqStack() {
        stack = new Stack<>();
        tmp = new Stack<>();
        freq = new HashMap<>();
        lFreq = 0;
    }
    
    public void push(int val) {
        stack.push(val);
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        if(freq.get(val) > lFreq){
            lFreq = freq.get(val);
        }
    }
    
    public int pop() {
        while(freq.get(stack.peek()) < lFreq){
            tmp.push(stack.pop());
        }
        freq.put(stack.peek(), freq.get(stack.peek()) - 1);
        while(!freq.containsValue(lFreq)){
            lFreq--;
        }
        int res = stack.pop();
        while(!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */