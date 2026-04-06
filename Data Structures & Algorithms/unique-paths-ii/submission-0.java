class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows+1][cols+1];
        dp[rows-1][cols-1] = 1;

        for(int r = rows-1; r >= 0; r--){
            for(int c = cols-1; c >= 0; c--){
                if(obstacleGrid[r][c] == 1){
                    dp[r][c] = 0;
                }else{
                    dp[r][c] += dp[r+1][c] + dp[r][c+1];
                }
                
            }
        }

        return dp[0][0];
    }
}