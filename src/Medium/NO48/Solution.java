package Medium.NO48;

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int i=0; i<m/2; i++){
            for (int j=0; j<m; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = tmp;
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
