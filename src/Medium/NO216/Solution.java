package Medium.NO216;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        inner(k, n, 1);
        return results;
    }

    public void inner(int k, int n, int cur){
        if (tmp.size()>k || tmp.size()+(9-cur+1)<k){
            return;
        }
        if (tmp.size()==k){
            int tmpSum = 0;
            for (int each:tmp){
                tmpSum += each;
            }
            if (tmpSum==n){
                results.add(new ArrayList<>(tmp));
                return;
            }
        }
        tmp.add(cur);
        inner(k, n, cur+1);
        tmp.remove(tmp.size()-1);
        inner(k, n, cur+1);
    }
}
