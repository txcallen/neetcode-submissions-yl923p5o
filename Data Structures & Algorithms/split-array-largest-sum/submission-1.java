class Solution {

    Map<String, Integer> map = new HashMap<>();
    public int splitArray(int[] nums, int k) {
        

        return dfs(nums, k, 0);
    }


    int dfs(int[] nums, int k, int idx){

        if(k == 1){
            int val = 0;
            for(int i = idx; i < nums.length; i++){
                val += nums[i];
            }
            return val;
        }

        String key = "key : " + k + "idx : " + idx;

        if(map.containsKey(key)){
            return map.get(key);
        }

        int res = Integer.MAX_VALUE;
        int curSum = 0;

        for(int i = idx; i < nums.length - k + 1; i++){
            curSum += nums[i];
            int maxSum = Math.max(curSum, dfs(nums, k-1, i+1));
            res = Math.min(maxSum, res);
        }

        map.put(key, res);

        return res;

    }
}