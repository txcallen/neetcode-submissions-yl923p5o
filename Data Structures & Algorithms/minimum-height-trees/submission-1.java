class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n <= 1){
            return List.of(0);
        }
        int[] degree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edg : edges){
            int n1 = edg[0];
            int n2 = edg[1];
            map.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            map.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
            degree[n1]++;
            degree[n2]++;
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                que.offer(i);
            }
        }
        int total = n;
        while(!que.isEmpty()){
            int size = que.size();
            if(total <= 2) break;
            while(size-- > 0){
                int cur = que.poll();
                total--;
                for(int next : map.getOrDefault(cur, new ArrayList<>())){
                    degree[next]--;
                    if(degree[next] == 1){
                        que.offer(next);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();

        
        while(!que.isEmpty()){
            res.add(que.poll());
        }

        return res;
    }
}