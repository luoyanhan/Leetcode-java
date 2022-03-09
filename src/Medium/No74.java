package Medium;

public class No74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            if (target>=matrix[0][0] || target<=matrix[m-1][n-1]){
                int left=0, right=m-1;
                while (left<=right){
                    int mid = left + (right-left)/2;
                    if (matrix[mid][0]<target){
                        left = mid+1;
                    }else if (matrix[mid][0]>target){
                        right = mid-1;
                    }else {
                        return true;
                    }
                }
                int row = left>0?left-1:left; //防止超出边界
                left = 0;
                right = n-1;
                while (left<=right){
                    int mid = left + (right-left)/2;
                    if (matrix[row][mid]<target){
                        left = mid+1;
                    }else if (matrix[row][mid]>target){
                        right = mid-1;
                    }else {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
