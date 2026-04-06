class Solution {
    public int lengthOfLIS(int[] nums) {
        
        TreeSet<Integer> set = new TreeSet<>();

        for(int n : nums){
            Integer ceil = set.ceiling(n);
            if(ceil != null){
                set.remove(ceil);
            }
            set.add(n);
        }

        return set.size();
    }
}
