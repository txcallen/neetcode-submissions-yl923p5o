class Solution {

    Map<String, Integer> dp = new HashMap<>();
    public boolean stoneGame(int[] piles) {
        
        int total = 0;

        for(int p : piles){
            total += p;
        }

        int alice = dfs(0, piles.length-1, piles);

        return alice > total - alice;
    }


    int dfs(int l, int r, int[] piles){
        if(l > r){
            return 0;
        }

        String key = l + ":" + r;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        boolean even = (r-l) % 2 == 0;

        int left = even ? piles[l] : 0;
        int right = even ? piles[r] : 0;


        int max = Math.max(dfs(l+1, r, piles) + left, dfs(l, r-1, piles) + right);

        dp.put(key, max);

        return max;
    }
}