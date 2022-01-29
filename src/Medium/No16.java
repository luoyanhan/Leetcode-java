package Medium;

import java.util.Arrays;

public class No16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int len = nums.length, res = 100000;
            for (int firstPtr=0; firstPtr<len-2; firstPtr++){
                if (firstPtr>0 && nums[firstPtr]==nums[firstPtr-1]){
                    continue;
                }
                int secondPtr=firstPtr+1, thirdPtr=len-1;
                while (secondPtr<thirdPtr){
                    int sum = nums[firstPtr] + nums[secondPtr] + nums[thirdPtr];
                    if (sum==target){
                        return target;
                    }
                    if (Math.abs(sum-target) < Math.abs(res-target)){
                        res = sum;
                    }
                    if (sum > target){
                        thirdPtr--;
                        while (thirdPtr>secondPtr && nums[thirdPtr]==nums[thirdPtr+1]){
                            thirdPtr--;
                        }
                    }else {
                        secondPtr++;
                        while (thirdPtr>secondPtr && nums[secondPtr]==nums[secondPtr-1]){
                            secondPtr++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
