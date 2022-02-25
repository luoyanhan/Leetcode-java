package Medium;

public class No50 {
    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            return n>0 ? innerPow(x, N) : 1.0/innerPow(x, -N);
        }
        public double innerPow(double x, long n){
            double res = 1.0;
            double contribution = x;
            while (n>0){
                if (n%2==1){
                    res*=contribution;
                }
                contribution*=contribution;
                n/=2;
            }
            return res;
        }
    }
}
