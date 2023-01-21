package Medium.NO73;

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col0ShouldZero = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i=0; i<m; i++){
            if (matrix[i][0]==0){
                col0ShouldZero = true;
            }
            for (int j=1; j<n; j++){
                if (matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=m-1; i>=0; i--){
            for (int j=1; j<n; j++){
                if (matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
            if (col0ShouldZero){
                matrix[i][0] = 0;
            }
        }
    }
}
