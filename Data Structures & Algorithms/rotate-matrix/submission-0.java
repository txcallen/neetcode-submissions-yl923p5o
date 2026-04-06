class Solution {
    public void rotate(int[][] matrix) {
        
        int top = 0;
        int bot = matrix.length-1;


        while(top < bot){
            int[] tmp = matrix[top];
            matrix[top] = matrix[bot];
            matrix[bot] = tmp;
            top++;
            bot--;
        }

        for(int r = 0; r < matrix.length; r++){
            for(int c = r; c < matrix[0].length; c++){

                int tmp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tmp;
            }
        }
    }
}
