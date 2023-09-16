package Medium.NO279;

class Solution {
    public int numSquares(int n) {
        int[] results = new int[n+1];
        for (int i=1; i<=n; i++){
            int minn = Integer.MAX_VALUE;
            for (int j=1; j*j<=i; j++){
                minn = Math.min(minn, results[i-j*j]);
            }
            results[i] = minn+1;
        }
        return results[n];
    }
}
