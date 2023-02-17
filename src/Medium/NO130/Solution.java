package Medium.NO130;

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i=0; i<rows; i++){
            recursion(board, i, 0);
            recursion(board, i, cols-1);
        }
        for (int j=1; j<cols-1; j++){
            recursion(board, 0, j);
            recursion(board, rows-1, j);
        }
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (board[i][j]=='A'){
                    board[i][j] = 'O';
                }else if (board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void recursion(char[][] board, int x, int y){
        if (x<0 || x>=board.length || y<0 || y>=board[0].length || board[x][y]!='O'){
            return;
        }
        board[x][y] = 'A';
        recursion(board, x+1, y);
        recursion(board, x-1, y);
        recursion(board, x, y+1);
        recursion(board, x, y-1);
    }
}
