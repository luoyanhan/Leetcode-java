package Medium;

import java.util.ArrayList;
import java.util.List;

public class No54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int rowNum=matrix.length, colNum=matrix[0].length;
            int left=0, right=colNum-1, top=0, bottom=rowNum-1;
            while (left<=right && top<=bottom){
                for (int col=left; col<=right; col++){
                    res.add(matrix[top][col]);
                }
                for (int row=top+1; row<=bottom; row++){
                    res.add(matrix[row][right]);
                }
                if (top<bottom && left<right){
                    for (int col=right-1; col>left; col--){
                        res.add(matrix[bottom][col]);
                    }
                    for (int row=bottom; row>top; row--){
                        res.add(matrix[row][left]);
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
