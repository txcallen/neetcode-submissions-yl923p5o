class MyHashSet {

    Integer[] store = new Integer[1000000];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        store[key] = key;
    }
    
    public void remove(int key) {
        if(store[key] != null){
            store[key] = null;
        }
    }
    
    public boolean contains(int key) {
        return store[key] != null;   
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */