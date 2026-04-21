class Solution {
    public int removeElement(int[] nums, int val) {
        
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                nums[i] = -1;
                k++;
            }
        }

        int left = 0, right = nums.length-1;

        for(int i = 0; i < nums.length - k; i++){
            if(nums[i] == -1){
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j] != -1){
                        swap(i, j, nums);
                        break;
                    }
                }
            }
        }
        
        return nums.length-k;

    }

    void swap(int left, int right, int[] nums){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}