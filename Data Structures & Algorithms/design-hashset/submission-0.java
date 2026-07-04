class MyHashSet {
    private ArrayList<Integer> hs;
    public MyHashSet() {
        hs = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!hs.contains(key)){
            hs.add(key);
        }
    }
    
    public void remove(int key) {
        hs.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return hs.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */