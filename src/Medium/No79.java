package Medium;

public class No79 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int row=0; row<board.length; row++){
                for (int col=0; col<board[0].length; col++){
                    if (check(board, visited, word, 0, row, col)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean check(char[][] board, boolean[][] visited, String word, int idx, int i, int j){
            if (board[i][j]!=word.charAt(idx)){
                return false;
            }else if (idx==word.length()-1){
                return true;
            }
            boolean res = false;
            visited[i][j] = true;
            int[][] neighbours = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] neighbour:neighbours){
                int x = i+neighbour[0], y = j+neighbour[1];
                if (x>=0 && x<board.length && y>=0 && y<board[0].length){
                    if (!visited[x][y] && check(board, visited, word, idx+1, x, y)){
                        res = true;
                        break;
                    }
                }
            }
            visited[i][j] = false;
            return res;
        }
    }
}
