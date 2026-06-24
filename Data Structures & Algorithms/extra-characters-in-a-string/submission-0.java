class Solution {

    Set<String> set = new HashSet<>();

    Map<Integer, Integer> dp = new HashMap<>();

    public int minExtraChar(String s, String[] dictionary) {
        
        for(String ss : dictionary){
            set.add(ss);
        }

        return dfs(s, 0);
    }


    private int dfs(String s, int idx){

        if(idx == s.length()){
            return 0;
        }

        if(dp.containsKey(idx)){
            return dp.get(idx);
        }

        int res = 1 + dfs(s, idx+1);
        for(int j = idx; j < s.length(); j++){
            if(set.contains(s.substring(idx, j+1))){
                res = Math.min(res, dfs(s, j+1));
            }
        }

        dp.put(idx, res);

        return res;
    }
}