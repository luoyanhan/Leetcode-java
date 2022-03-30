package Medium;

public class No96 {
    class Solution {
        public int numTrees(int n) {
            int[] records = new int[n+1];
            records[0] = 1;
            records[1] = 1;
            for (int num=2; num<=n; num++){
                for (int root=1; root<=num; root++){
                    records[num] += records[root-1]*records[num-root];
                }
            }
            return records[n];
        }
    }
}
