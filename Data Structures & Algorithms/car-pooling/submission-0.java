class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int[] trip : trips){
            int pas = trip[0];
            int start = trip[1];
            int end = trip[2];
            map.put(start, map.getOrDefault(start, 0) + pas);
            map.put(end, map.getOrDefault(end, 0) - pas);
        }

        int initialCap = 0;
        for(int key : map.keySet()){
            int val = map.get(key);
            initialCap += val;
            if(initialCap > capacity){
                return false;
            }
        }

        return true;


    }
}