package Medium.NO74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row=0, left=row, right=m-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (matrix[mid][n-1]<target){
                left = mid+1;
            }else {
                if (mid==left || matrix[mid-1][n-1]<target){
                    row = mid;
                    break;
                }else {
                    right = mid-1;
                }
            }
        }

        left = 0;
        right=n-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (matrix[row][mid]==target){
                return true;
            }else if (matrix[row][mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return false;
    }
}
