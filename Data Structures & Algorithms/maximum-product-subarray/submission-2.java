class Solution {
    public int maxProduct(int[] nums) {
        
        int res = nums[0];
        int min = 1;
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            int tmp = max * nums[i];
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(tmp, Math.min(min * nums[i], nums[i]));
            

            res = Math.max(res, max);
        }

        return res;
    }
}
