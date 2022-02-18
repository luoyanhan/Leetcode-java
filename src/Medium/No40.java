package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40 {
    public static void main(String[] args){
        No40 n = new No40();
        Solution s = n.new Solution();
        List res = s.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(res);
    }

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            List<int[]> records = new ArrayList<>();
            Arrays.sort(candidates);
            for (int num: candidates){
                int size = records.size();
                if (!records.isEmpty() && records.get(size-1)[0]==num){
                    records.get(size-1)[1]++;
                }else {
                    records.add(new int[]{num, 1});
                }
            }
            dfs(res, tmp, 0, target, records);
            return res;
        }

        public void dfs(List<List<Integer>> res, List<Integer> tmp, int idx, int target, List<int[]> records){
            if (target==0){
                res.add(new ArrayList<>(tmp));
                return;
            }
            if (idx>=records.size() || records.get(idx)[0]>target){
                return;
            }
            dfs(res, tmp, idx+1, target, records);
            int num = records.get(idx)[0];
            int count = records.get(idx)[1];
            int max = Math.min(count, target/num);
            for (int i=1; i<=max; i++){
                tmp.add(num);
                dfs(res, tmp, idx+1, target-i*num, records);
            }
            for (int i=1; i<=max; i++){
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
