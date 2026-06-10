class Solution {
    int res = 0;
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        

        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    visited[i][j] = true;
                    dfs(i, j, grid, rows, cols);
                    return res;
                }
            }
        }

        return res;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    void dfs(int r, int c, int[][] grid, int rows, int cols){

        int cnt = 0;
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == 0){
                res++;
                continue;
            }

            if(visited[nr][nc] == true){
                continue;
            }

            visited[nr][nc] = true;
            if(grid[nr][nc] == 1){
                dfs(nr, nc, grid, rows, cols);
            }
        }
        
    }
}