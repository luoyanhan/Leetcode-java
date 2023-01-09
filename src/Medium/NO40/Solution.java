package Medium.NO40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<int[]> occurNumber = new ArrayList<int[]>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        for (int i=0; i<candidates.length; i++){
            if (occurNumber.isEmpty() || occurNumber.get(occurNumber.size()-1)[0]!=candidates[i]){
                occurNumber.add(new int[]{candidates[i], 1});
            }else {
                occurNumber.get(occurNumber.size()-1)[1]++;
            }
        }
        backTrack(occurNumber, 0, target, res, combine);
        return res;
    }

    public void backTrack(List<int[]> occurNumber, int index, int target, List<List<Integer>> res, List<Integer> combine){
        if (target==0){
            res.add(new ArrayList<Integer>(combine));
            return;
        }
        if (index==occurNumber.size() || target<occurNumber.get(index)[0]){
            return;
        }
        backTrack(occurNumber, index+1, target, res, combine);

        int maxTimes = Math.min(occurNumber.get(index)[1], target/occurNumber.get(index)[0]);
        for (int i=1; i<=maxTimes; i++){
            combine.add(occurNumber.get(index)[0]);
            backTrack(occurNumber, index+1, target-i*occurNumber.get(index)[0], res, combine);
        }
        for (int i=1; i<=maxTimes; i++){
            combine.remove(combine.size()-1);
        }
    }
}
