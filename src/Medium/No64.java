package Medium;

public class No64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] map = new int[n];
            map[0] = grid[0][0];
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    if (j>0 && i>0){
                        map[j] = Math.min(map[j], map[j-1]) + grid[i][j];
                    }else if (j==0 && i>0){
                        map[j] += grid[i][j];
                    }else if (j>0 && i==0){
                        map[j] = map[j-1] + grid[i][j];
                    }
                }
            }
            return map[n-1];
        }
    }

    public static void main(String[] args){
        No64 n = new No64();
        Solution s = n.new Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(s.minPathSum(grid));
    }
}

