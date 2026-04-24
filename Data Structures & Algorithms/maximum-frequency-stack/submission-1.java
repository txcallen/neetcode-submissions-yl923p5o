class FreqStack {
    
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Deque<Integer>> stack = new HashMap<>();
    int maxCnt = 0;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int curFreq = freq.getOrDefault(val, 0) + 1;
        freq.put(val, curFreq);
        if(curFreq > maxCnt){
            maxCnt = curFreq;
            stack.put(maxCnt, new ArrayDeque<>());
        }

        stack.get(curFreq).push(val);
    }
    
    public int pop() {
        
        Deque<Integer> dq = stack.get(maxCnt);
        
        int val = dq.pop();
        freq.put(val, freq.get(val)-1);
        if(dq.isEmpty()){
            maxCnt--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */