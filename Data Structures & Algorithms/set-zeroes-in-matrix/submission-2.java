class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean firstRow = false;

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(matrix[r][c] == 0){

                    matrix[0][c] = 0;
                    if(r == 0){
                        firstRow = true;
                    }else{
                        matrix[r][0] = 0;
                    }

                }
            }
        }

        for(int r = 1; r < matrix.length; r++){
            for(int c = 1; c < matrix[0].length; c++){
                if(matrix[r][0] == 0 || matrix[0][c] == 0){
                    matrix[r][c] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if(firstRow){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
    }
}
