class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {


        dfs(new ArrayList<>(), 1, n, k);
        return list;    

    }


    void dfs(List<Integer> cur, int idx, int n, int k){

        if(cur.size() == k){

            list.add(new ArrayList<>(cur));
            return;
        }

        for(int i = idx; i <= n; i++){
            cur.add(i);
            dfs(cur, i+1, n, k);
            cur.remove(cur.size()-1);
        }
    }
}