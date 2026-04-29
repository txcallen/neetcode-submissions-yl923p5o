class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int l = 0, r = nums.length-1;
        int res = nums.length;
        while(l <= r){
            int mid = l + (r - l) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                res = mid;
                r = mid -1 ;
            }else{
                l = mid + 1;
            }
        }

        return res;
        
    }
}