package Medium.NO204;

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        int res = 0;
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i=2; i<n; i++){
            if (isPrime[i]==1) {
                res++;
                if ((long)i*i<n){
                    for (int num = i * i; num < n; num += i) {
                        isPrime[num] = 0;
                    }
                }
            }
        }
        return res;
    }
}
