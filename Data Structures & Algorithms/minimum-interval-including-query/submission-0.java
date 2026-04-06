class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int q : Arrays.stream(queries).sorted().toArray()){

            while(idx < intervals.length && intervals[idx][0] <= q){
                int leng = intervals[idx][1] - intervals[idx][0] + 1;
                pq.offer(new int[]{leng, intervals[idx][1]});
                idx++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < q){
                pq.poll();
            }

            map.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }
        int i = 0;
        int[] res = new int[queries.length];
        for(int q : queries){
            res[i++] = map.get(q);
        }

        return res;

        
    }
}
