package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47 {
    class Solution {
        boolean[] visited;
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            visited = new boolean[nums.length];
            List<Integer> tmp = new ArrayList<>();
            Arrays.sort(nums);
            backTrack(res, 0, tmp, nums);
            return res;
        }
        public void backTrack(List<List<Integer>> res, int idx, List<Integer> tmp, int[] nums){
            if (idx==nums.length){
                res.add(new ArrayList<>(tmp));
            }
            for (int i=0; i<nums.length; i++){
                if ((i>0 && nums[i]==nums[i-1] && !visited[i-1]) || visited[i]){
                    continue;
                }
                visited[i]=true;
                tmp.add(nums[i]);
                backTrack(res, idx+1, tmp, nums);
                tmp.remove(tmp.size()-1);
                visited[i]=false;
            }
        }
    }
}
