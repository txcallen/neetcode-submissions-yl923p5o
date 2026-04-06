class Solution {

    Map<Integer, Integer> cache = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return dfs(nums, target);
    }

    int dfs(int[] nums, int target){
        if(target == 0){
            return 1;
        }

        if(target < 0){
            return 0;
        }

        if(cache.get(target) != null){
            return cache.get(target);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(target > 0){
                res += dfs(nums, target-cur);
            }
        }

        cache.put(target, res);
        return cache.get(target);
    }
}