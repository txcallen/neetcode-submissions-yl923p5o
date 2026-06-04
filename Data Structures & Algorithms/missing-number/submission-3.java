class Solution {
    public int missingNumber(int[] nums) {
        

        int find = 0;
        Arrays.sort(nums);        

        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(cur != find){
                return find;
            }

            find++;
        }

        return find ;
    }
}
