class Solution {
    Map<Integer, Integer> cache = new HashMap<>(); 
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }

        if(cache. containsKey(n)){
            return cache.get(n);
        }

        int val =  climbStairs(n-1) + climbStairs(n-2);

        cache.putIfAbsent(n, val);
        return val;
    }
}
