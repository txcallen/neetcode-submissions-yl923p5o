class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] edg : edges){
            int n1 = edg[0];
            int n2 = edg[1];
            map.computeIfAbsent(n1, k -> new HashSet<>()).add(n2);
            map.computeIfAbsent(n2, k -> new HashSet<>()).add(n1);
        }

        int depth = n;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int newDepth = bfs(map, i);
            if(newDepth < depth){
                depth = newDepth;
                res = new ArrayList<>();
                res.add(i);
            }
            else if(newDepth == depth){
                res.add(i);
            }
        }

        return res;
    }

    int bfs(Map<Integer, Set<Integer>> map, int root){

        Queue<Integer> que = new LinkedList<>();
        que.offer(root);
        Set<Integer> visited = new HashSet<>();
        int depth = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int cur = que.poll();
                visited.add(cur);

                for(int next : map.getOrDefault(cur, new HashSet<>())){
                    if(visited.contains(next)){
                        continue;
                    }
                    que.offer(next);
                }
            }
            depth++;
        }
        System.out.println(root + " " + depth);
        return depth;
    }
}