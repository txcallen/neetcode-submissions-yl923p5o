class Solution {
    Integer[][] dp;
    public String stoneGameIII(int[] stoneValue) {
        
        int n = stoneValue.length;
        dp = new Integer[n][2];

        int res = dfs(0, 1, stoneValue);
        if(res == 0){
            return "Tie";
        }else{
            return res > 0 ? "Alice" : "Bob";
        }
    }

    int dfs(int idx, int alice, int[] stoneValue){
        int n = stoneValue.length;
        if(idx >= n){
            return 0;
        }

        if(dp[idx][alice] != null){
            return dp[idx][alice];
        }
        int res = alice == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int total = 0;
        for(int i = idx; i < Math.min(idx+3, n); i++){
            if(alice == 1){
                total += stoneValue[i];
                res = Math.max(res, total + dfs(i+1, 0, stoneValue));
            }else{
                total -= stoneValue[i];
                res = Math.min(res, total + dfs(i+1, 1, stoneValue));
            }
        }

        dp[idx][alice] = res;
        return res;

    }
}