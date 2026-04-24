class Solution {
    public int[][] transpose(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] res = new int[cols][rows];

        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                res[i][j] = matrix[j][i];
            }
        }

        return res;
    }
}