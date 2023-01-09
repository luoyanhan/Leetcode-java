package Medium.NO39;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        backTrack(candidates, 0, target, res, combine);
        return res;
    }

    public void backTrack(int[] candidates, int index, int target, List<List<Integer>> res, List<Integer> combine){
        if (index==candidates.length){
            return;
        }
        if (target==0){
            res.add(new ArrayList<Integer>(combine));
            return;
        }
        backTrack(candidates, index+1, target, res, combine);
        if (target>=candidates[index]){
            combine.add(candidates[index]);
            backTrack(candidates, index, target-candidates[index], res, combine);
            combine.remove(combine.size()-1);
        }
    }
}
