class Solution {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;

        for(int n : nums){
            sum += n;
        }

        if(sum % k != 0) return false;
        int target = sum / k;

        // Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        return dfs(0, target, 0, used, k, nums);    
    }


    boolean dfs(int idx, int target, int curSum, boolean[] used, int k, int[] nums){

        if(k == 0){
            return true;
        }

        if(curSum == target){
            return dfs(0, target, 0, used, k-1, nums);
        }

        for(int i = idx; i < nums.length; i++){
            if(used[i] || nums[i] + curSum > target){
                continue;
            }
            used[i] = true;
            if(dfs(i+1, target, nums[i] + curSum, used, k, nums)){
                return true;
            }
            used[i] = false;
            
        }

        return false;
    }
}