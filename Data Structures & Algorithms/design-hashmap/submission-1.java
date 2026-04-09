class MyHashMap {

    List<Integer>[] bucket;
    int capacity = 1000000;
    double loadFactor = 0.75;

    public MyHashMap() {
        this.capacity = capacity;
        bucket = new LinkedList[capacity];
    }

    
    public void put(int key, int value) {
        int idx = hash(key);
        if(bucket[idx] == null){
            bucket[idx] = new LinkedList<>();
        }
            
        bucket[idx].add(0,value);
        
    }

    private int hash(int key){
        return key % capacity;
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(bucket[idx] == null){
            return -1;
        }

        return bucket[idx].get(0);
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(bucket[idx] != null){
            bucket[idx] = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */