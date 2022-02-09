package Medium;

public class No29 {
    class Solution {
        public int divide(int dividend, int divisor) {
            int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
            if (dividend==MIN && divisor==-1){
                return MAX;
            }
            int sign=-1;
            if ((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
                sign = 1;
            }
            dividend = dividend>0?-dividend:dividend;
            divisor = divisor>0?-divisor:divisor;
            int res=0;
            while (dividend<=divisor){
                int tmp=divisor, count=1;
                while (tmp>=dividend-tmp){
                    tmp += tmp;
                    count += count;
                }
                dividend -= tmp;
                res += count;
            }
            return res*sign;
        }
    }
}
