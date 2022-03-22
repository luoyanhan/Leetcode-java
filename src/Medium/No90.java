package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<int[]> records = new ArrayList<>();
            for (int num:nums){
                int size = records.size();
                if (!records.isEmpty() && records.get(size-1)[0]==num){
                    records.get(size-1)[1] += 1;
                }else {
                    records.add(new int[]{num, 1});
                }
            }
            dfs(records, 0);
            return res;
        }

        private void dfs(List<int[]> records, int cur){
            if (cur==records.size()){
                res.add(new ArrayList<>(tmp));
                return;
            }
            int[] record = records.get(cur);
            int num = record[0];
            int cnt = record[1];
            dfs(records, cur+1);
            for (int idx=0; idx<cnt; idx++){
                tmp.add(num);
                dfs(records, cur+1);
            }
            for (int idx=0; idx<cnt; idx++){
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
