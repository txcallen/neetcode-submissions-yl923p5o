class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int r = 0, c = 0;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int[][] dirs = new int[][]{
            {0, 1}, //right
            {1, 0}, //down
            {0,-1}, //left
            {-1, 0}};//up

        List<Integer> list = new ArrayList<>();
        int cur = 0;
        for(int i = 0; i < m * n; i++){
            list.add(matrix[r][c]);
            visited[r][c] = true;
            int nr = r + dirs[cur][0];
            int nc = c + dirs[cur][1];

            if(nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]){
                cur = (cur + 1) % 4;
                nr = r + dirs[cur][0];
                nc = c + dirs[cur][1];
            }

            r = nr;
            c = nc;

        }

        return list;
    }
}
