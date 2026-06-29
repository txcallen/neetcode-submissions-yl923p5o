class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        List<int[]> lists = new ArrayList<>();
        int idx = 0;
        for(int[] edg : edges){
            lists.add(new int[]{edg[0], edg[1], edg[2], idx});
            idx++;
        }

        Collections.sort(lists, (a, b) -> a[2] - b[2]);
        int mstWeight = 0;
        UnionFind uf = new UnionFind(n);

        for(int[] list : lists){
            if(uf.union(list[0], list[1])){
                mstWeight += list[2];
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for(int[] list : lists){

            int weight = 0;
            UnionFind ufWithout = new UnionFind(n);

            for(int[] other : lists){
                if(other[3] != list[3]){ // exclude current edge
                    if(ufWithout.union(other[0], other[1])){
                        weight += other[2];
                    }
                }
            }

            if(Arrays.stream(ufWithout.rank).max().getAsInt() != n || 
            weight > mstWeight){
                critical.add(list[3]);
                continue;
            }

            weight = 0;
            UnionFind ufWith = new UnionFind(n);
            ufWith.union(list[0], list[1]);
            weight += list[2];
            for(int[] other : lists){
                if(ufWith.union(other[0], other[1])){
                    weight += other[2];
                }
            }

            if(weight == mstWeight){
                pseudo.add(list[3]);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pseudo);
        return res; 
    }
}

class UnionFind {

    int[] par;
    int[] rank;
    int n;

    UnionFind(int n){
        this.n = n;
        this.par = new int[n];
        this.rank = new int[n];

        for(int i = 0; i < n; i++){
            this.par[i] = i;
            this.rank[i] = 1;
        }
    }


    int find(int node){
        if(node != par[node]){
            par[node] = find(par[node]);
        }

        return par[node];
    }

    boolean union(int nodeA, int nodeB){

        int rootA = find(nodeA), rootB = find(nodeB);

        if(rootA == rootB){
            return false;
        }

        if(rank[rootA] > rank[rootB]){
            rank[rootA] += rank[rootB];
            par[rootB] = rootA;
        }else{
            rank[rootB] += rank[rootA];
            par[rootA] = rootB;
        }

        return true;
    }

}