class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0, right = 0;
        int curSum = 0, min = Integer.MAX_VALUE;
        while(right < nums.length){
            curSum += nums[right];
            while(curSum >= target){
                min = Math.min(min, right - left + 1);
                curSum -= nums[left];
                left++;
            }
            right++;
            System.out.println(curSum);
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}