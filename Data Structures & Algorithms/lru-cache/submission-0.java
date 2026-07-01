public class CacheNode{
    int key;
    int val;
    CacheNode prev;
    CacheNode next;

    public CacheNode(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private int capacity;
    private HashMap<Integer, CacheNode> cache;
    private CacheNode left_node;
    private CacheNode right_node; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left_node = new CacheNode(0, 0);
        this.right_node = new CacheNode(0, 0);
        this.left_node.next = this.right_node;
        this.right_node.prev = this.left_node;
    }

    public void remove(CacheNode node) {
        CacheNode prev = node.prev;
        CacheNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void insert(CacheNode node) {
        CacheNode prev = this.right_node.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right_node;
        this.right_node.prev = node;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }
        CacheNode newNode = new CacheNode(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > capacity){
            CacheNode lru = this.left_node.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
