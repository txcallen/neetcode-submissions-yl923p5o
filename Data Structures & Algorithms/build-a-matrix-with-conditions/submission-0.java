class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int[][] res = new int[k][k];


        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        int[] rowDegree = new int[k+1];
        for(int[] rc : rowConditions){
            int r1 = rc[0];
            int r2 = rc[1];
            rowMap.computeIfAbsent(r1, key -> new ArrayList<>()).add(r2);
            rowDegree[r2]++;
        }

        int[] colDegree = new int[k+1];
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        for(int[] cc : colConditions){
            int c1 = cc[0];
            int c2 = cc[1];
            colMap.computeIfAbsent(c1, key -> new ArrayList<>()).add(c2);
            colDegree[c2]++;
        }

        Queue<Integer> rowQue = new LinkedList<>();
        Queue<Integer> colQue = new LinkedList<>();
        for(int i = 1; i <=k; i++){
            if(rowDegree[i] == 0){
                rowQue.offer(i);
            }
            if(colDegree[i] == 0){
                colQue.offer(i);
            }
        }

        Map<Integer, Integer> rowOrders = findOrder(rowDegree, rowQue, rowMap);//2,1,3
        Map<Integer, Integer> colOrders = findOrder(colDegree, colQue, colMap);//2,3,1

        if(rowOrders.isEmpty() || colOrders.isEmpty()){
            return new int[0][0];
        }

        for(int i = 1; i <= k; i++){
            int rowIdx = rowOrders.get(i);
            int colIdx = colOrders.get(i);
            res[rowIdx][colIdx] = i;
        }

        return res;
    }


    Map<Integer, Integer> findOrder(int[] degree, Queue<Integer> que, Map<Integer, List<Integer>> map){
        
        Map<Integer, Integer> res = new HashMap<>();

        if(que.isEmpty()){
            return res;
        }
        
        int order = 0;

        while(!que.isEmpty()){
            int cur = que.poll();
            res.put(cur, order++);
            for(int next : map.getOrDefault(cur, new ArrayList<>())){
                degree[next]--;
                if(degree[next] == 0){
                    que.offer(next);
                }
            }
        }

        return res;

    }
}