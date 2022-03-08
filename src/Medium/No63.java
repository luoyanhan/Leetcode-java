package Medium;

public class No63 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid[0].length;
            int m = obstacleGrid.length;
            int[] map = new int[n];
            map[0] = obstacleGrid[0][0]==0?1:0;
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    if (obstacleGrid[i][j]==1){
                        map[j]=0;
                    }else if (j>0){
                        map[j] += map[j-1];
                    }
                }
            }
            return map[n-1];
        }
    }
}
