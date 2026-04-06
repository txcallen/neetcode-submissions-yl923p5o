class Solution {
    public int minPathSum(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        dp[rows-1][cols-1] = grid[rows-1][cols-1];
        
        for(int i = rows-1; i >=0; i--){
            for(int j = cols-1; j >= 0; j--){
                int rightVal = Integer.MAX_VALUE;
                if(j+1 <= cols-1){
                    rightVal = dp[i][j+1];
                }
                int downVal = Integer.MAX_VALUE;
                if(i+1 <= rows-1){
                    downVal = dp[i+1][j];
                }
                int min = Math.min(rightVal, downVal) == Integer.MAX_VALUE ? 0 : Math.min(rightVal, downVal);
                dp[i][j] = grid[i][j];
                dp[i][j] += min;
            }
        }

        return dp[0][0];
    }
}