class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();


        for(int i = 0; i < nums.length-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(int j = i+1; j < nums.length-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                int left = j+1, right = nums.length-1;
                long toSum = (long)target - nums[i] - nums[j];
                while(left < right){
                    int leftVal = nums[left];
                    int rightVal = nums[right];
                    long curSum = (long)leftVal + rightVal;

                    if(curSum < toSum){
                        left++;
                    }else if(curSum > toSum){
                        right--;
                    }else{
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]){
                        left++;
                        }
                        while(left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }

                    
                    
                }
            }
        }

        return res;
    }
}