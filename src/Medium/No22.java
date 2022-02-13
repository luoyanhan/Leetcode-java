package Medium;

import java.util.ArrayList;
import java.util.List;

public class No22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            backtrace(res, new StringBuilder(), 0, 0, n);
            return res;
        }
        public void backtrace(List<String> res, StringBuilder cur, int left, int right, int n){
            if (cur.length()==2*n){
                res.add(cur.toString());
            }
            if (left<n){
                cur.append("(");
                backtrace(res, cur, left+1, right, n);
                cur.deleteCharAt(cur.length()-1);
            }
            if (left>right){
                cur.append(")");
                backtrace(res, cur, left, right+1, n);
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }
}
