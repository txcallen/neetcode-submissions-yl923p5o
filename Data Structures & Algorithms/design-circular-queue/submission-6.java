class MyCircularQueue {

    int[] store;
    int start = 0;
    int end = -1;
    int size = 0;
    int maxSize = 0;
    public MyCircularQueue(int k) {
        store = new int[k];
        maxSize = k;
    }
    
    public boolean enQueue(int value) {
        
        if(size >= maxSize){
            return false;
        }

        end = (end+1) % maxSize;
        store[end] = value;
        size++;

        return true;
    }
    
    public boolean deQueue() {
        
        if(size == 0){
            return false;
        }

        start = (start+1) % maxSize;
        size--;

        return true;
    }
    
    public int Front() {
        return !isEmpty() ? store[start] : -1;
    }
    
    public int Rear() {
        return !isEmpty() ? store[end] : -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
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