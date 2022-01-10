package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No1 {
    private class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i=0; i < nums.length; i++){
                for (int j=i+1; j < nums.length; j++){
                    if (nums[i]+nums[j]==target){
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }
    }

    private class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i=0; i<n; i++){
                if (map.containsKey(target-nums[i])){
                    return new int[]{i, map.get(target-nums[i])};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
