class MyQueue {
    Deque<Integer> stk1 = new ArrayDeque<>();
    Deque<Integer> stk2 = new ArrayDeque<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!stk2.isEmpty()){
            stk1.push(stk2.pop());
        }
        stk1.push(x);
    }
    
    public int pop() {
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        return stk2.pop();
    }
    
    public int peek() {
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        return stk2.peek();
    }
    
    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */