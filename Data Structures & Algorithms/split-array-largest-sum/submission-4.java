class Solution {
    public int splitArray(int[] nums, int k) {
        
        int sum = 0;
        int maxVal = 0;

        for(int i : nums){
            maxVal = Math.max(maxVal, i);
            sum += i;
        }

        int left = maxVal;
        int right = sum;

        
        int res = right;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canSplit(nums, k, mid)){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        return res;
    }

    boolean canSplit(int[] nums, int k, int largest){
        int cnt = 1;
        int curSum = 0;
        for(int i : nums){
            curSum += i;
            if(curSum > largest){
                cnt++;
                curSum = i;
            }
            if(cnt > k) return false;
        }

        return true;
    }
}