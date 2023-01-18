package Medium.NO54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<Integer>();
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols-1, bottom = rows-1, top = 0;
        while (left<=right && top<=bottom){
            System.out.println(left);
            System.out.println(right);
            System.out.println(top);
            System.out.println(bottom);
            //等号避免中心处无法添加
            for (int i=left; i<=right; i++){
                answer.add(matrix[top][i]);
            }
            for (int j=top+1; j<=bottom; j++){
                answer.add(matrix[j][right]);
            }
            //if条件避免矩阵只有一列的时候重复添加
            if (left<right && top<bottom){
                for (int i=right-1; i>left; i--){
                    answer.add(matrix[bottom][i]);
                }
                for (int j=bottom; j>top; j--){
                    answer.add(matrix[j][left]);
                }
            }
            left += 1;
            right -= 1;
            top += 1;
            bottom -= 1;
        }
        return answer;
    }
}
