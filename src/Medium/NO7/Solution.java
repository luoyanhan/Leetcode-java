package Medium.NO7;

class Solution {
    public int reverse(int x) {
        int tmp = 0, ans = 0;
        while (x!=0){
            tmp = x % 10;
            if (ans > 214748364 || (ans == 214748364 && tmp > 7)){
                return 0;
            }
            if (ans < -214748364 || (ans == -214748364 && tmp < -8)){
                return 0;
            }
            ans = ans*10 + tmp;
            x = x/10;
        }
        return ans;
    }
}
