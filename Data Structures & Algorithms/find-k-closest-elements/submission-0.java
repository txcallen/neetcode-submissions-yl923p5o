class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> res = new ArrayList<>();

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);


        for(int i = 0; i < arr.length; i++){
            int cur = arr[i];
            int diff = Math.abs(cur - x);
            pq.offer(new int[]{diff, i});
        }


        while(k-- > 0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            // System.out.println(Arrays.toString(cur));
            res.add(arr[cur[1]]);
        }

        Collections.sort(res);

        return res;
    }
}