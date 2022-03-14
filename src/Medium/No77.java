package Medium;

import java.util.ArrayList;
import java.util.List;

public class No77 {
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            inner(tmp, res, 1, n, k);
            return res;
        }
        private static void inner(List<Integer> tmp, List<List<Integer>> res, int cur, int n, int k){
            if (n-cur+1<k-tmp.size()){
                return;
            }
            if (tmp.size()==k){
                res.add(new ArrayList<>(tmp));
                return;
            }
            inner(tmp, res, cur+1, n, k);
            tmp.add(cur);
            inner(tmp, res, cur+1, n, k);
            tmp.remove(tmp.size()-1);
        }
    }
}
