class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int lastStoneWeightII(int[] stones) {
        
        int sum = 0, target = 0;

        for(int s : stones){
            sum += s;
        }

        target = (1+sum) / 2;

        return dfs(0, 0, stones, target, sum);
    }

    int dfs(int idx, int curSum, int[] stones, int target, int sum){
        if(curSum >= target || idx >= stones.length){
            return Math.abs(curSum - (sum - curSum));
        }
        String key = idx + "-" + curSum;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int res = Math.min(dfs(idx+1, curSum, stones, target, sum), 
        dfs(idx+1, curSum+stones[idx], stones, target, sum));

        dp.put(key, res);

        return res;
    }
}