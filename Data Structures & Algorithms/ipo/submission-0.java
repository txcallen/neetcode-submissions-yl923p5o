class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);//min heap

        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);


        for(int i = 0; i < profits.length; i++){
            minHeap.offer(new int[]{profits[i], capital[i]});
        }


        int cnt = 0;

        while(cnt++ < k){
            
            while(!minHeap.isEmpty() && minHeap.peek()[1] <= w){
                maxHeap.offer(minHeap.poll());
            }

            if(maxHeap.isEmpty()){
                break;
            }

            w += maxHeap.poll()[0];

        }




        return w;
        



    }
}