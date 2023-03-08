package Medium.NO166;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long)numerator;
        long denominatorLong = (long)denominator;
        if (numeratorLong%denominatorLong==0){
            return String.valueOf(numeratorLong/denominatorLong);
        }
        StringBuffer res = new StringBuffer();
        if (numeratorLong<0 ^ denominatorLong<0){
            res.append('-');
        }

        long absNumerator = Math.abs(numeratorLong);
        long absDenominator = Math.abs(denominatorLong);
        long intPart = absNumerator/absDenominator;
        res.append(String.valueOf(intPart));
        res.append('.');

        long remain = absNumerator%absDenominator;
        StringBuffer dec = new StringBuffer();
        Map<Long, Integer> record = new HashMap<>();
        int idx = 0;
        while (remain!=0&&!record.containsKey(remain)){
            record.put(remain, idx);
            dec.append(String.valueOf(remain*10/absDenominator));
            remain = remain*10%absDenominator;
            idx++;
        }
        if (remain!=0){
            idx = record.get(remain);
            dec.insert(idx, '(');
            dec.append(')');
        }
        res.append(dec.toString());
        return res.toString();
    }
}
