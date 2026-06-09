class Solution {
    public int majorityElement(int[] nums) {
        
        int maj = nums.length / 2;

        Map<Integer, Integer> freq  = new HashMap<>();

        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            if(freq.get(n) > maj){
                return n;
            }
        }

        return -1;
    }
}