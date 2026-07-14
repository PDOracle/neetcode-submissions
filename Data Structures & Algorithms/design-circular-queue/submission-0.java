class ListNode {
    int val;
    ListNode next;

    public ListNode(int x){
        this.val = x;
        this.next = null; 
    }        
}

class MyCircularQueue {
    private ListNode left;
    private ListNode right;
    private int space;

    public MyCircularQueue(int k) {
        this.space = k;
        this.left = new ListNode(0);
        this.right = this.left;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        ListNode tmp = new ListNode(value);
        if(isEmpty()){
            this.left.next = tmp;
            this.right = tmp;
        }
        else{
            this.right.next = tmp;
            this.right = tmp;
        }
        this.space--;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        this.left.next = this.left.next.next;
        if(this.left.next == null){
            this.right = this.left;
        }
        this.space++;
        return true;

    }
    
    public int Front() {
        return isEmpty() ? -1 : this.left.next.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : this.right.val;
    }
    
    public boolean isEmpty() {
        return this.left.next == null;
    }
    
    public boolean isFull() {
        return this.space == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */