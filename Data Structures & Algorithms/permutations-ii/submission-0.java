class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        dfs(nums, new ArrayList<>(), res);

        return new ArrayList<>(res);
    }

    void dfs(int[] nums, List<Integer> list, Set<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != Integer.MIN_VALUE){
                int tmp = nums[i];
                list.add(nums[i]);
                nums[i] = Integer.MIN_VALUE;
                dfs(nums, list, res);
                nums[i] = tmp;
                list.remove(list.size()-1);
            }
        }
    }
}