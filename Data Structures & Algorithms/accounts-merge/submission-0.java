class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, Integer> emailGroup = new HashMap<>();

        int size = accounts.size();
        UnionFind uf = new UnionFind(size);

        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);

            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if(emailGroup.containsKey(email)){
                    uf.union(i, emailGroup.get(email));
                }else{
                    emailGroup.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> emailLeader = new HashMap<>();
        for(String email : emailGroup.keySet()){
            int acctId = emailGroup.get(email);
            int leader = uf.find(acctId);
            emailLeader.computeIfAbsent(leader, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> list = new ArrayList<>();

        for(int acctId : emailLeader.keySet()){
            List<String> emails = emailLeader.get(acctId);
            Collections.sort(emails);
            String name = accounts.get(acctId).get(0);

            List<String> merge = new ArrayList<>();
            merge.add(name);
            merge.addAll(emails);
            list.add(merge);
        }



        return list;
    }
}


class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x1, int x2) {
        int p1 = find(x1);
        int p2 = find(x2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}


/*
 1 :["neet","neet@gmail.com","neet_dsa@gmail.com"],
 2 :["alice","alice@gmail.com"],
 1 :["neet","bob@gmail.com","neet@gmail.com"],
 3 :["neet","neetcode@gmail.com"]


*/