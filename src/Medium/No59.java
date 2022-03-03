package Medium;

public class No59 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int left=0, right=n-1, top=0, bottom=n-1;
            int cur=1;
            while (left<=right && top<=bottom){
                for (int col=left; col<=right; col++){
                    res[top][col]=cur;
                    cur++;
                }
                for (int row=top+1; row<=bottom; row++){
                    res[row][right]=cur;
                    cur++;
                }
                if (left<right && top<bottom){
                    for (int col=right-1; col>left; col--){
                        res[bottom][col]=cur;
                        cur++;
                    }
                    for (int row=bottom; row>top; row--){
                        res[row][left]=cur;
                        cur++;
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return res;
        }
    }
}
