class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        return dfs(s, 0);
    }

    int dfs(String s, int idx){
        if(idx == s.length()){
            return 1;
        }
        if(s.charAt(idx) == '0'){
            return 0;
        }
        if(cache.containsKey(idx)){
            return cache.get(idx);
        }
        int cnt = dfs(s, idx+1);
        if(idx < s.length()-1){
            if (s.charAt(idx) == '1' ||
               (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')) {
                cnt += dfs(s, idx+2);
            }
        }
        cache.put(idx, cnt);
        return cnt;
    }
}
