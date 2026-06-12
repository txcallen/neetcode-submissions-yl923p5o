class LFUCache {

    int cap = 0;
    int lfuCount = 0;
    Map<Integer, ListNode> nodeMap;
    Map<Integer, DLinkedList> listMap;
    public LFUCache(int capacity) {
        this.cap = capacity;    
        lfuCount = 0;
        nodeMap = new HashMap<>();
        listMap = new HashMap<>();
    }

    public void setCountAndMoveNode(ListNode node){
        int freq = node.freq;

        listMap.get(freq).remove(node);

        if(freq == lfuCount && listMap.get(freq).size == 0){
            lfuCount++;
        }

        node.freq++;
        listMap.putIfAbsent(node.freq, new DLinkedList());
        listMap.get(node.freq).pushRight(node);
    }
    
    public int get(int key) {
        
        if(!nodeMap.containsKey(key)){
            return -1;
        }

        ListNode node = nodeMap.get(key);
        setCountAndMoveNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {

        if(cap == 0){
            return;
        }

        if(nodeMap.containsKey(key)){
            ListNode node = nodeMap.get(key);
            node.val = value;
            setCountAndMoveNode(node);
        }

        if(nodeMap.size() == cap){
            ListNode node = listMap.get(lfuCount).removeLeft();
            nodeMap.remove(node.key);
        }

        ListNode node = new ListNode(key, value);
        lfuCount = 1;
        nodeMap.put(key, node);
        listMap.putIfAbsent(lfuCount, new DLinkedList());
        listMap.get(lfuCount).pushRight(node);
        
    }
}

class ListNode{

    int key;
    int val;
    int freq;
    ListNode next, prev;

    ListNode(int key, int val){
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DLinkedList{
    private ListNode left, right;
    private int size;

    DLinkedList(){
        this.left = new ListNode(0, 0);
        this.right = new ListNode(0, 0);
        this.left.next = right;
        this.right.prev = left;
        this.size = 0;
    }

    int getSize(){
        return this.size;
    }

    void pushRight(ListNode node){
        ListNode tmp = this.right.prev;
        this.right.prev = node;
        node.next = this.right;
        node.prev = tmp;
        tmp.next = node;
        size++;
    }

    void remove(ListNode node){
        ListNode pre = node.prev, next = node.next;
        pre.next = next;
        next.prev = pre;
        node.next = null;
        node.prev = null;
        size--;
    }

    ListNode removeLeft(){
        ListNode removeNode = left.next;
        remove(removeNode);
        return removeNode;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */