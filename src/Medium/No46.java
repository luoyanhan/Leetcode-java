package Medium;

import java.util.ArrayList;
import java.util.List;

public class No46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for (int num:nums){
                tmp.add(num);
            }
            backTrack(res, 0, tmp);
            return res;
        }

        public void backTrack(List<List<Integer>> res, int idx, List<Integer> tmp){
            if (idx==tmp.size()){
                res.add(new ArrayList<>(tmp));
            }
            for (int i=idx; i<tmp.size(); i++){
                Integer t = tmp.get(idx);
                tmp.set(idx, tmp.get(i));
                tmp.set(i, t);
                backTrack(res, idx+1, tmp);
                t = tmp.get(idx);
                tmp.set(idx, tmp.get(i));
                tmp.set(i, t);
            }
        }
    }
}
