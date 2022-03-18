package Medium;

import java.util.ArrayList;
import java.util.List;

public class No78 {
    static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums, 0);
            return res;
        }
        private void dfs(int[] nums, int cur){
            int length = nums.length;
            if (length==cur){
                res.add(new ArrayList<>(tmp));
                return;
            }
            dfs(nums, cur+1);
            tmp.add(nums[cur]);
            dfs(nums, cur+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
