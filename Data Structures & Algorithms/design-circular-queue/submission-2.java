class MyCircularQueue {
    Node head = new Node();
    
    Node end = new Node();
    

    int size = 0;
    int maxSize = 0;
    public MyCircularQueue(int k) {
        head.val = -1;
        end.val = -1;
        head.next = end;
        end.pre = head;
        maxSize = k;
    }
    
    public boolean enQueue(int value) {
        if(size >= maxSize){
            return false;
        }
        Node node = new Node();
        node.val = value;

        Node tmp = end.pre;
        end.pre = node;
        tmp.next = node;

        node.pre = tmp;
        node.next = end;

        size++;

        return true;
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        Node first = head.next;

        head.next = first.next;
        first.next.pre = head;

        size--;

        return true;
    }
    
    public int Front() {
        
        return head.next.val;
    }
    
    public int Rear() {
        return end.pre.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }
}

class Node{

    Node next;
    Node pre;
    int val;

    Node(){
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