package Medium;

public class No8 {
    class Solution {
        public int myAtoi(String s) {
            int res = 0, idx=0, len=s.length();
            Boolean isNegative = false;
            while (idx<len && s.charAt(idx)==' '){
                idx++;
            }
            int begin=idx;
            while (idx<len){
                if (begin==idx&&s.charAt(idx)=='+'){
                    isNegative = false;
                }else if (begin==idx&&s.charAt(idx)=='-'){
                    isNegative = true;
                }else if (Character.isDigit(s.charAt(idx))){
                    int num = Integer.parseInt(String.valueOf(s.charAt(idx)));
                    if (res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10)){
                        return Integer.MAX_VALUE;
                    }else if (res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10&&-num<Integer.MIN_VALUE%10)){
                        return Integer.MIN_VALUE;
                    }
                    if (!isNegative){
                        res = res*10 + num;
                    }else {
                        res = res*10 - num;
                    }
                }else {
                    break;
                }
                idx++;
            }
            return res;
        }
    }
}
