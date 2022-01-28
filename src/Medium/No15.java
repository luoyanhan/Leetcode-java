package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            int len = nums.length;
            Arrays.sort(nums);
            for (int firstPtr=0; firstPtr<len-2; firstPtr++){
                if (firstPtr>0 && nums[firstPtr]==nums[firstPtr-1]){
                    continue;
                }
                int thirdPtr = len-1;
                for (int secondPtr=firstPtr+1; secondPtr<len-1; secondPtr++){
                    if (secondPtr>firstPtr+1 && nums[secondPtr]==nums[secondPtr-1]){
                        continue;
                    }
                    while (thirdPtr>secondPtr && nums[thirdPtr]+nums[secondPtr]>-nums[firstPtr]){
                        thirdPtr--;
                    }
                    if (thirdPtr==secondPtr){
                        break;
                    }
                    if (nums[thirdPtr]+nums[secondPtr]==-nums[firstPtr]){
                        List<Integer> inner = new ArrayList<>();
                        inner.add(nums[firstPtr]);
                        inner.add(nums[secondPtr]);
                        inner.add(nums[thirdPtr]);
                        res.add(inner);
                    }
                }
            }
            return res;
        }
    }
}
