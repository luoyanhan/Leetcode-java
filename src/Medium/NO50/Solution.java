package Medium.NO50;

class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return n>0?quickMul(x, N):(1.0/quickMul(x, -N));
    }

    public double quickMul(double x, long N){
        double contribution = x, res = 1.0;
        while (N>0){
            if (N%2==1){
                res *= contribution;
            }
            contribution *= contribution;
            N/=2;
        }
        return res;
    }
}
