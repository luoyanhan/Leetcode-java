package Medium.NO200;

class Solution {
    public int numIslands(char[][] grid) {
        int rowsNum = grid.length;
        int colsNum = grid[0].length;
        int res = 0;
        for (int r=0; r<rowsNum; r++){
            for (int c=0; c<colsNum; c++){
                if (grid[r][c]=='1'){
                    res += 1;
                    recursion(r, c, rowsNum, colsNum, grid);
                }
            }
        }
        return res;
    }

    public void recursion(int r, int c, int rowsNum, int colsNum, char[][] grid){
        if (r<0 || c<0 || r>=rowsNum || c>=colsNum || grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';
        recursion(r, c+1, rowsNum, colsNum, grid);
        recursion(r, c-1, rowsNum, colsNum, grid);
        recursion(r+1, c, rowsNum, colsNum, grid);
        recursion(r-1, c, rowsNum, colsNum, grid);
    }
}
