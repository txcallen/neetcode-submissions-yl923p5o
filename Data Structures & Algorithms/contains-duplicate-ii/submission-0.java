class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();

        while(right < nums.length){
            if(!set.add(nums[right])){
                return true;
            }
            right++;
            while(Math.abs(right - left) > k){
                set.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}