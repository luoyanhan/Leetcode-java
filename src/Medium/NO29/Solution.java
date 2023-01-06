package Medium.NO29;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend==0){
            return 0;
        }
        if (dividend==Integer.MIN_VALUE){
            if (divisor==1){
                return Integer.MIN_VALUE;
            }
            if (divisor==-1){
                return Integer.MAX_VALUE;
            }
        }
        if (divisor==Integer.MIN_VALUE){
            if (dividend==Integer.MIN_VALUE){
                return 1;
            }else {
                return 0;
            }
        }
        int rev = 1;
        if (dividend>0){
            dividend = -dividend;
            rev *= -1;
        }
        if (divisor>0){
            divisor = -divisor;
            rev *= -1;
        }

        int left=1, right=Integer.MAX_VALUE, ans=0;
        while (left<=right){
            int mid = left + ((right-left)>>1);
            if (quickAdd(divisor, mid, dividend)){
                ans = mid;
                if (mid==Integer.MAX_VALUE){
                    break;
                }
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return rev==-1?-ans:ans;
    }

    public boolean quickAdd(int y, int z, int x){
        int result=0, add=y;
        while (z!=0){
            if ((z&1)!=0){
                if (result < x-add){
                    return false;
                }
                result += add;
            }
            if (z!=1){
                if (add < x-add){
                    return false;
                }
                add += add;
            }
            z>>=1;
        }
        return true;
    }
}
