class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int res = 0;

        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, 1);
        }

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                map.put(i, map.get(i-1)+1);
            }
        }

        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1] && map.get(i) <= map.get(i+1)){
                map.put(i, map.get(i+1)+1);
            }
        }

        for(int i : map.keySet()){
            res += map.get(i);
        }

        return res;
    }
}