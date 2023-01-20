package Medium.NO63;

class Solution {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid.length, n = obstacleGrid[0].length;
//        int[][] answer = new int[m][n];
//        answer[0][0] = 1;
//        for (int i=0; i<m; i++){
//            for (int j=0; j<n ;j++){
//                if (i>0 && obstacleGrid[i-1][j]==0){
//                    answer[i][j] += answer[i-1][j];
//                }
//                if (j>0 && obstacleGrid[i][j-1]==0){
//                    answer[i][j] += answer[i][j-1];
//                }
//            }
//        }
//        return obstacleGrid[m-1][n-1]==0?answer[m-1][n-1]:0;
//    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i=0; i<m; i++){
            for (int j=0; j<n ;j++){
                if (i>0 && obstacleGrid[i-1][j]==1){
                    answer[j] = 0;
                }
                if (j>0 && obstacleGrid[i][j-1]==0){
                    answer[j] += answer[j-1];
                }
            }
        }
        return obstacleGrid[m-1][n-1]==0?answer[n-1]:0;
    }
}
