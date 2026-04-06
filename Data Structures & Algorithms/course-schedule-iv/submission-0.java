class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        int[] indegree = new int[numCourses];

        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();


        for(int[] pre : prerequisites){
            int start = pre[0];
            int end = pre[1];
            map.computeIfAbsent(start, k -> new HashSet<>()).add(end);
            indegree[end]++;
            preMap.computeIfAbsent(end, k -> new HashSet<>()).add(start);
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int next : map.getOrDefault(cur, new HashSet<>())){
                indegree[next]--;
                if(indegree[next] == 0){
                    que.offer(next);
                }
                Set<Integer> currDep = preMap.getOrDefault(cur, new HashSet<>());
                preMap.getOrDefault(next, new HashSet<>()).addAll(currDep);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries){
            int q1 = q[0];
            int q2 = q[1];

            res.add(preMap.getOrDefault(q2, new HashSet<>()).contains(q1));
        }

        return res;
    }
}