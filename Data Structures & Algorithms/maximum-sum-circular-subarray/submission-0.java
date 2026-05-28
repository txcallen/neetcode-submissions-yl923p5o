class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int curmax = 0, curmin = 0;
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            total += cur;

            curmax = Math.max(curmax + cur, cur);
            max = Math.max(max, curmax);


            curmin = Math.min(curmin + cur, cur);
            min = Math.min(curmin, min);
        }

        if(max < 0) return max;

        return Math.max(max, total - min);
    }
}