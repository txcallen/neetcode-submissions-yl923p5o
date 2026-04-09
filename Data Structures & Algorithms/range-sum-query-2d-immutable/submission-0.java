class NumMatrix {

    int[][] prefix;
    int rows, cols;

    private int[][] sumMat;

    public NumMatrix(int[][] matrix) {
        
        rows = matrix.length;
        cols = matrix[0].length;

        prefix = new int[rows+1][cols+1];

        for(int r = 1; r < rows+1; r++){
            int prefixSum = 0;
            for(int c = 1; c < cols+1; c++){
                prefixSum = prefixSum + matrix[r-1][c-1];
                prefix[r][c] = prefixSum + prefix[r-1][c];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;

        int curSum = prefix[row2][col2];
        int sub1 = prefix[row1-1][col2];
        int sub2 = prefix[row2][col1-1];
        return curSum - sub1 - sub2 + prefix[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */