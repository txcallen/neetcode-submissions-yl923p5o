class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0,1);
        int prefix = 0;
        int res = 0;
        int[] prefixArr = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            prefixArr[i+1] = prefix;
            res += map.getOrDefault(prefix - k, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return res;
        
    }
}


/*
[2, -1, 1, 2]
 0, 2,  1, 2, 4

0:1
2:2
1:1
4:1

[4, 4, 4, 4, 4, 4]
 0, 4, 8, 12, 16, 20, 24

 0:1
 4:1
 8:1
 12:1
 16:1
 20:1
 24:1

*/