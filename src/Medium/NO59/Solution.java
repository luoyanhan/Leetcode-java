package Medium.NO59;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int left=0, right=n-1, top=0, bottom=n-1;
        int number=1;
        while (left<=right && top<=bottom){
            for (int i=left; i<=right; i++){
                answer[top][i] = number;
                number++;
            }
            for (int i=top+1; i<=bottom; i++){
                answer[i][right] = number;
                number++;
            }
            if (left<right && top<bottom){
                for (int i=right-1; i>=left; i--){
                    answer[bottom][i] = number;
                    number++;
                }
                for (int i=bottom-1; i>top; i--){
                    answer[i][left] = number;
                    number++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return answer;
    }
}
