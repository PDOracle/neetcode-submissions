class StockSpanner {
    private Stack<Integer> stockPrice;
    private Stack<Integer> stockSpan;
    public StockSpanner() {
        stockPrice = new Stack<>();
        stockSpan = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stockPrice.isEmpty() && stockPrice.peek() <= price){
            span++;
            stockSpan.push(stockPrice.pop());
        }
        while(!stockSpan.isEmpty()){
            stockPrice.push(stockSpan.pop());
        }
        stockPrice.push(price);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */