class Solution {
    public int firstMissingPositive(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                nums[i] = 0;
            }
        }

        int len = nums.length;

        for(int i = 0; i < nums.length; i++){
            int n = Math.abs(nums[i]);
            if(n >= 1 && n <= len){
                if(nums[n-1] > 0){
                    nums[n-1] *= -1;
                }else if(nums[n-1] == 0){
                    nums[n-1] = -1 * (len+1);
                }
            }
        }

        for(int i = 1; i <= len; i++){
            if(nums[i-1] >= 0){
                return i;
            }
        }

        return len+1;
    }
}