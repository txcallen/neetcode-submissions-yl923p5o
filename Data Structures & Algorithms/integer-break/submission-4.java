class Solution {
    Integer[] dp;
    public int integerBreak(int n) {
        
        if(n == 1){
            return 1;
        }
        dp = new Integer[n+1];
        return dfs(n, n);
    }


    int dfs(int n, int original){
        if(n == 1){
            return 1;
        }


        if(dp[n] != null){
            return dp[n];
        }

        int res = (n == original) ? 0 : n;
        for(int i = 1; i < n; i++){
            int val = dfs(i, original) * dfs(n-i, original);
            res = Math.max(res, val);
        }
        dp[n] = res;
        return res;
    }
}