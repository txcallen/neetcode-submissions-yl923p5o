class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        UnionFind uf = new UnionFind(nums.length);
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int first = nums[i];
                int second = nums[j];
                if(findGcd(first, second) > 1){
                    uf.union(i, j);
                }
            }
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(uf.find(i) != uf.find(j)){
                    return false;
                }
            }
        }

        return true;
    }

    int findGcd(int a, int b){
        if(a == 0){
            return b;
        }

        return findGcd(b%a, a);
    }
}

class UnionFind{

    int[] parent;

    UnionFind(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    int find(int node){
        if(parent[node] != node){
            return find(parent[node]);
        }

        return node;
    }

    void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return;
        }

        parent[rootA] = rootB;
    }
}


