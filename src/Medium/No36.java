package Medium;

public class No36 {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] cols = new int[9][9];
            int[][][] smallSquare = new int[3][3][9];
            for (int i=0; i<9; i++){
                for (int j=0; j<9; j++){
                    if (board[i][j] != '.'){
                        int num = board[i][j]-'0';
                        if (rows[i][num-1]>0 || cols[j][num-1]>0 || smallSquare[i/3][j/3][num-1]>0){
                            return false;
                        }
                        rows[i][num-1]++;
                        cols[j][num-1]++;
                        smallSquare[i/3][j/3][num-1]++;
                    }
                }
            }
            return true;
        }
    }
}
