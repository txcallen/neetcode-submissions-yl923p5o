class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int cnt = nums.length / 3;
        List<Integer> res = new ArrayList<>();

        for(int key : map.keySet()){
            int curFreq = map.get(key);
            if(curFreq > cnt){
                res.add(key);
            }
        }

        return res;
    }
}