package Medium.NO36;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowRecord = new int[9][9];
        int[][] colRecord = new int[9][9];
        int[][][] squreRecord = new int[3][3][9];
        for (int row=0; row<9; row++){
            for (int col=0; col<9; col++){
                if (board[row][col]!='.'){
                    int numIdx = board[row][col] - '0' - 1;
                    rowRecord[row][numIdx] += 1;
                    colRecord[col][numIdx] += 1;
                    squreRecord[row/3][col/3][numIdx] += 1;
                    if (rowRecord[row][numIdx]>1 || colRecord[col][numIdx]>1 || squreRecord[row/3][col/3][numIdx]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
