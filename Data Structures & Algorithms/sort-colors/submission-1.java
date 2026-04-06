class Solution {
    public void sortColors(int[] nums) {
        
        int start = 0, end = nums.length-1;

        for(int i = 0; i < nums.length && i <= end; ){
            int cur = nums[i];
            if(cur == 0){
                swap(i, start++, nums);
                i++;
            }
            if(cur == 2){
                swap(i, end--, nums);
            }
            if(cur == 1){
                i++;
            }
        }
    }

    void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// [0,1,1,2]

