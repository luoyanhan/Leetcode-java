package Medium.NO241;

import java.util.ArrayList;
import java.util.List;


class Solution {
    char[] chars;

    public List<Integer> diffWaysToCompute(String expression) {
        chars = expression.toCharArray();
        return dfs(0, chars.length-1);
    }

    public List<Integer> dfs(int left, int right){
        List<Integer> res = new ArrayList<>();
        for (int i=left; i<=right; i++){
            if (Character.isDigit(chars[i])){
                continue;
            }
            List<Integer> l = dfs(left, i-1);
            List<Integer> r = dfs(i+1, right);
            for (int a:l){
                for (int b:r){
                    int tmp = 0;
                    if (chars[i]=='+'){
                        tmp = a + b;
                    }else if (chars[i]=='-'){
                        tmp = a - b;
                    }else if (chars[i]=='*'){
                        tmp = a * b;
                    }
                    res.add(tmp);
                }
            }
        }
        if (res.isEmpty()){
            int s = 0;
            for (int i=left; i<=right; i++){
                s = s*10 + chars[i]-'0';
            }
            res.add(s);
        }
        return res;
    }
}
