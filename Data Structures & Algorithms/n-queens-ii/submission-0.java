class Solution {
    int rows, cols;
    int cnt = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for(char[] b : board){
            Arrays.fill(b, '*');
        }

        dfs(board, 0, n);
        return cnt;
    }


    void dfs(char[][] board, int r, int n){
        if(r >= n){
            cnt++;
            return;
        }

        for(int c = 0; c < n; c++){
            if(isValid(board, r, c)){
                board[r][c] = 'Q';
                dfs(board, r+1, n);
                board[r][c] = '*';
            }
        }
    }

    boolean isValid(char[][] board, int r, int c){
        for(int i = r; i >= 0; i--){
            if(board[i][c] == 'Q'){
                return false;
            }
        }

        for(int i = r, j = c; i >= 0 && j < board[0].length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = r, j = c; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}