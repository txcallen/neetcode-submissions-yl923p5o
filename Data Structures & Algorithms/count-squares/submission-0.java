class CountSquares {

    Map<String, Integer> cnt;
    List<int[]> points;
    public CountSquares() {
        cnt = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        String key = point[0] + "#" + point[1];
        cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        points.add(point);
    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0];
        int py = point[1];

        for(int[] existing : points){
            int ex = existing[0];
            int ey = existing[1];

            if(ex == px || ey == py || Math.abs(ex - px) != Math.abs(ey - py)){
                continue;
            }

            res += cnt.getOrDefault(ex + "#" + py, 0)
            * cnt.getOrDefault(px + "#" + ey, 0);

            
        }
        return res;
    }
}
