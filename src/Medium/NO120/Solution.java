package Medium.NO120;

import java.util.List;

//class Solution {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int[][] record = new int[n][n];
//        record[0][0] = triangle.get(0).get(0);
//        for (int i=1; i<n; i++){
//            record[i][0] = record[i-1][0] + triangle.get(i).get(0);
//            for (int j=1; j<i; j++){
//                record[i][j] = Math.min(record[i-1][j-1], record[i-1][j]) + triangle.get(i).get(j);
//            }
//            record[i][i] = record[i-1][i-1] + triangle.get(i).get(i);
//        }
//        int res = record[n-1][0];
//        for (int i=1; i<n; i++){
//            res = Math.min(res, record[n-1][i]);
//        }
//        return res;
//    }
//}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] record = new int[2][n];
        record[0][0] = triangle.get(0).get(0);
        for (int i=1; i<n; i++){
            int curRow = i % 2 ;
            int preRow = 1 - curRow;
            record[curRow][0] = record[preRow][0] + triangle.get(i).get(0);
            for (int j=1; j<i; j++){
                record[curRow][j] = Math.min(record[preRow][j-1], record[preRow][j]) + triangle.get(i).get(j);
            }
            record[curRow][i] = record[preRow][i-1] + triangle.get(i).get(i);
        }
        int tarRow = (n-1)%2;
        int res = record[tarRow][0];
        for (int i=1; i<n; i++){
            res = Math.min(res, record[tarRow][i]);
        }
        return res;
    }
}
