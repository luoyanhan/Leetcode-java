package Medium.NO64;

class Solution {
//    public int minPathSum(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int[][] answer = new int[m][n];
//        answer[0][0] = grid[0][0];
//        for (int i=0; i<m; i++){
//            for (int j=0; j<n; j++){
//                int up = i>0?answer[i-1][j]:Integer.MAX_VALUE;
//                int left = j>0?answer[i][j-1]:Integer.MAX_VALUE;
//                if (i>0 || j>0){
//                    answer[i][j] = grid[i][j] + Math.min(up, left);
//                }
//            }
//        }
//        return answer[m-1][n-1];
//    }
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] answer = new int[n];
        answer[0] = grid[0][0];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int up = i>0?answer[j]:Integer.MAX_VALUE;
                int left = j>0?answer[j-1]:Integer.MAX_VALUE;
                if (i>0 || j>0){
                    answer[j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return answer[n-1];
    }
}
