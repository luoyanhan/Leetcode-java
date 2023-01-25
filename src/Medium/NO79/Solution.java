package Medium.NO79;

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (backTrack(board, i, j, visited, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrack(char[][] board, int row, int col,  boolean[][] visited, String word, int idx){
        if (idx==word.length()){
            return true;
        }
        if (row<0 || row>=board.length || col<0 || col>=board[0].length || visited[row][col] || board[row][col]!=word.charAt(idx)){
            return false;
        }
        visited[row][col] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction:directions){
            int newRow = row + direction[0], newCol = col + direction[1];
            boolean res = backTrack(board, newRow, newCol, visited, word, idx+1);
            if (res){
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
