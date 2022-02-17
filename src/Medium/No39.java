package Medium;

import java.util.ArrayList;
import java.util.List;

public class No39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            dfs(res, tmp, 0, target, candidates);
            return res;
        }

        public void dfs(List<List<Integer>> res, List<Integer> tmp, int idx, int target, int[] candidates){
            if (idx>=candidates.length){
                return ;
            }else if (target==0){
                res.add(new ArrayList<Integer>(tmp));;
            }else {
                dfs(res, tmp, idx+1, target, candidates);
                if (target-candidates[idx]>=0){
                    tmp.add(candidates[idx]);
                    dfs(res, tmp, idx, target-candidates[idx], candidates);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
}
