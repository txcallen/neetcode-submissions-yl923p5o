class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;

        for(int n : nums){
            sum += n;
        }


        if(sum % 2 != 0){
            return false;
        }

        int target = sum / 2;

        return dfs(0, nums, target);
    }

    boolean dfs(int idx, int[] nums, int target){
        if(idx == nums.length){
            return target == 0;
        }

        if(target < 0){
            return false;
        }

        return dfs(idx + 1, nums, target - nums[idx]) || 
        dfs(idx+1, nums, target);
    }

}
