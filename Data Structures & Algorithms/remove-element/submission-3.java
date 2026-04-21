class Solution {
    public int removeElement(int[] nums, int val) {
        
        int k = 0;



        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        
        return k;

    }

    void swap(int left, int right, int[] nums){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}