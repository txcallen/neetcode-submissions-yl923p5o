class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Deque<int[]> dq = new ArrayDeque<>();

        int max = 0;

        for(int i = 0; i < heights.length; i++){
            int cur = heights[i];
            int curIdx = i;
            while(!dq.isEmpty() && cur <= dq.peek()[0]){
                int[] pair = dq.pop();
                int h = pair[0];
                int idx = pair[1];
                max = Math.max(max, (i - idx) * h);
                curIdx = idx;
            }
            dq.push(new int[]{cur, curIdx});
        }

        int n = heights.length;

        while(!dq.isEmpty()){
            int[] pair = dq.pop();
            max = Math.max(max, (n-pair[1]) * pair[0]);
        }

        return max;
    }
}
